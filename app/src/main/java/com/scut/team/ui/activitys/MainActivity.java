package com.scut.team.ui.activitys;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scut.team.R;
import com.scut.team.ui.base.BasePageActivity;

import java.util.ArrayList;

/**
 * 程序主界面
 */
public class MainActivity extends BasePageActivity {
    private PopupWindow mFunctionPopupWindow;
    private ListView mBoardListView;
    private TextView mTitleTextView;
    private RelativeLayout mTitleRelativieLayout;
    private ArrayList mBoradList;

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void findViews() {
        mBoardListView = (ListView) findViewById(R.id.main_lv_my_board);
    }

    protected void setupViews(Bundle bundle) {
        mTabWidget = findView(R.id.tabwidget);
        mViewPager = findView(R.id.viewpager);
        //设置主界面下方的图标
        View tab1 = LayoutInflater.from(this).inflate(R.layout.tab1, null);
        View tab2 = LayoutInflater.from(this).inflate(R.layout.tab2, null);
        View tab3 = LayoutInflater.from(this).inflate(R.layout.tab3, null);
        mTabWidget.addTab(tab1);
        mTabWidget.addTab(tab2);
        mTabWidget.addTab(tab3);
        mTabWidget.setDividerInvisible();

        mPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(mPagerAdapter);
        mTabWidget.setmViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(2);

        mTabWidget.setmOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onSelected(List<View> tabViews, int position) {
                switch (position) {
                    case 0:
                        aQuery.id(R.id.img_tab_calendar).image(R.mipmap.ic_calendar_grey);
                        aQuery.id(R.id.img_tab_user).image(R.mipmap.ic_user_grey);
                        aQuery.id(R.id.img_tab_timetable).image(R.mipmap.ic_timetable);
                        break;
                    case 1:
                        aQuery.id(R.id.img_tab_calendar).image(R.mipmap.ic_calendar);
                        aQuery.id(R.id.img_tab_user).image(R.mipmap.ic_user_grey);
                        aQuery.id(R.id.img_tab_timetable).image(R.mipmap.ic_timetable_grey);
                        break;
                    case 2:
                        aQuery.id(R.id.img_tab_calendar).image(R.mipmap.ic_calendar_grey);
                        aQuery.id(R.id.img_tab_user).image(R.mipmap.ic_user);
                        aQuery.id(R.id.img_tab_timetable).image(R.mipmap.ic_timetable_grey);
                        break;
                }
            }
        });
    }

    protected void setListener() {
        aQuery.id(R.id.btn_title_left).clicked(this, "onBackPressed");
        aQuery.id(R.id.btn_title_right2).clicked(this, "createTimetable");
        aQuery.id(R.id.btn_title_right).clicked(this, "search");
    }

    protected void fetchData() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String timeTableString = gson.toJson(createTimetable);
        LogUtil.i(timeTableString);
    }

    protected void createBoard(String boardName) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String timeTableString = gson.toJson(createTimetable);
        LogUtil.i(timeTableString);
        Map<String, String> param = new HashMap<>();
        param.put("data", timeTableString);
        Net.post(Constant.URL.Add, param, new Net.NetworkListener() {
            @Override
            public void onSuccess(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.optInt("state") == 0) {
                        toast("添加成功");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    remoteAdd(createTimetable);
                }
            }

            @Override
            public void onFail(String error) {
                remoteAdd(createTimetable);
            }
        });
    }

    protected void onBoardClick() {
    }

    protected void onBoradLongClick() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("确定退出？")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        builder.create().show();
    }

}
