package com.scut.team.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.scut.team.R;
import com.scut.team.ui.base.BasePageActivity;

/**
 * Created by host on 2016/1/4.
 */
public class SettingActivity extends BasePageActivity {
    @Override
    protected void setLayoutView() {
        setContentView(R.layout.activity_setting);
    }

/**
 * this is for setting and configuration
 *
 * /
    @Override
    public void initView() {
        user = DBhelper.getInstance().getFirstUser();
        aQuery.id(R.id.mdf_name).text(user.getUsername());
        aQuery.id(R.id.mdf_phone).text(user.getPhone());
        aQuery.id(R.id.mdf_detail).text(user.getDetail());
        LogUtil.i(gson.toJson(user));
    }

    @Override
    void setListener() {
        View nameModify = findView(R.id.btn_mdf_name);
        nameModify.setOnClickListener(new View.OnClickListener() {
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

        View detailModify = findView(R.id.btn_mdf_detail);
        detailModify.setOnClickListener(new View.OnClickListener() {
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

        View passwordModify = findView(R.id.btn_mdf_password);
        passwordModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(Constant.DataKey.EDIT_TYPE, Constant.Code.PASSWORD_EDIT);
                Intent intent = new Intent(getActivity(), EditActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, Constant.Code.PASSWORD_EDIT);
            }
        });

        View logoff = findView(R.id.btn_mdf_logoff);
        logoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmHelper.getInstance().cancelAll();
                DBhelper.getInstance().drop();
                SpUtils spUtils = new SpUtils(getContext());
                spUtils.clear();
                getActivity().finish();
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });
    }
    */

}
