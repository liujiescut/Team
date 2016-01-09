package com.scut.team.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scut.team.R;
import com.scut.team.ui.base.BasePageActivity;

import java.util.ArrayList;

/**
 * create for search any borad card or list
 * Created by host on 2016/1/8.
 */
public class SearchActivity extends BasePageActivity {
    ListView mResultListView;
    TextView mTitleTextView;
    RelativeLayout mTitleRelativieLayout;
    ArrayList mResultList;
    EditText mKeyWordEditText;
    Button mSearchButton;

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.activity_setting);
    }

    protected void findViews() {
        user = DBhelper.getInstance().getFirstUser();
        aQuery.id(R.id.mdf_name).text(user.getUsername());
        aQuery.id(R.id.mdf_phone).text(user.getPhone());
        aQuery.id(R.id.mdf_detail).text(user.getDetail());
        LogUtil.i(gson.toJson(user));
    }

    protected void setupViews(Bundle bundle) {
        listView = (ListView) findViewById(R.id.listview);
        searchEditText = (EditText) findViewById(R.id.et_search);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        timeTableList = new ArrayList<>();
        timeTableAdapter = new TimeTableAdapter(this,timeTableList);
        listView.setAdapter(timeTableAdapter);
        listView.setDivider(null);
    }

    protected void setListener() {
        View nameSearch = findView(R.id.btn_mdf_name);
        nameSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(Constant.DataKey.EDIT_TYPE, Constant.Code.NAME_EDIT);
                bundle.putString(Constant.DataKey.EDTI_DATA, user.getUsername());
                Intent intent = new Intent(getActivity(), EditActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, Constant.Code.NAME_EDIT);
            }
        });

        View detailSearch = findView(R.id.btn_mdf_detail);
        detailSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(Constant.DataKey.EDIT_TYPE, Constant.Code.DETAIL_EDIT);
                bundle.putString(Constant.DataKey.EDTI_DATA, user.getDetail());
                Intent intent = new Intent(getActivity(), EditActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, Constant.Code.DETAIL_EDIT);
            }
        });

        View passwordSearch = findView(R.id.btn_mdf_password);
        passwordSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(Constant.DataKey.EDIT_TYPE, Constant.Code.PASSWORD_EDIT);
                Intent intent = new Intent(getActivity(), EditActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, Constant.Code.PASSWORD_EDIT);
            }
        });
    }

    protected void search(String keyWord) {
        String searchkey = searchEditText.getText().toString();
        if (searchkey.length() == 0) {
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        List<TimeTable> selected = new ArrayList<>();
        for(TimeTable t:DBhelper.getInstance().getFirstUser().getTimeTables()){
            if(t.getTitle().contains(searchkey)||t.getText().contains(searchkey)){
                selected.add(t);
            }
        }
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        LogUtil.i(gson.toJson(selected));
        refresh(selected);
        progressBar.setVisibility(View.GONE);
    }

}
