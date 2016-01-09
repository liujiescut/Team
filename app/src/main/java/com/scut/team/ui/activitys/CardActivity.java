package com.scut.team.ui.activitys;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scut.team.R;
import com.scut.team.model.Card;
import com.scut.team.model.User;
import com.scut.team.ui.base.BasePageActivity;

import java.util.ArrayList;

/**
 * create for the detail of Card
 * Created by host on 2016/1/8.
 */
public class CardActivity extends BasePageActivity {
    private PopupWindow mFunctionPopupWindow;
    private TextView mBoardNameTextView;
    private Fragment mListFragment;
    private TextView mTitleTextView;
    private RelativeLayout mTitleRelativieLayout;
    private ArrayList mCardList;

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.activity_board);
    }

    protected void findViews() {
        User user = DBhelper.getInstance().getFirstUser();
        Card selectCard = new Card();
        selectCard.setDueDate(DueDate);
        Cards.clear();
        for (Card t : user.getCards()) {
            if (t.getDueDateString().equals(selectCard.getDueDateString())) {
                Cards.add(t);
            }
        }
    }

    protected void setupViews(Bundle bundle) {
        convertView = inflater.inflate(R.layout.fragment_calendar, container, false);
        CardView = findView(R.id.calendar_view);
    }

    protected void setListener() {
        CardView.setOnDueDateSelectedListener(new CardView.OnDueDateSelectedListener() {
            @Override
            public void onDueDateSelected(DueDate DueDate) {
                initView();
            }

            @Override
            public void onDueDateUnselected(DueDate DueDate) {

            }
        });
    }

    protected void fetchData() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.DataKey.card, cards.get(position));
                Intent intent = new Intent(getActivity(), cardActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, Constant.Code.MODIFY_card);
            }
        });

    }

    protected void renameBoard(String newBoardName) {
        //设置长按删除
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                String[] items = {"删除"};
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //远程删除
                                remoteDelete(cards.get(position).getId());
                                //数据库中删除
                                DBhelper.getInstance().delete(cards.get(position));
                                Activity mainActivity = getActivity();
                                if(mainActivity instanceof MainActivity){
                                    ((MainActivity)mainActivity).fragmentInitView();
                                }
                            }
                        })
                        .create();
                alertDialog.show();
                return true;
            }
        });
        setLeftListener();
    }

    protected void createList(String listName) {
        //设置长按删除
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                String[] items = {"删除"};
                AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //远程增加
                                remoteAdd(cards.get(position).getId());
                                //数据库中添加
                                DBhelper.getInstance().add(cards.get(position));
                                Activity mainActivity = getActivity();
                                if(mainActivity instanceof MainActivity){
                                    ((MainActivity)mainActivity).fragmentInitView();
                                }
                            }
                        })
                        .create();
                alertDialog.show();
                return true;
            }
        });
        setLeftListener();
    }

}
