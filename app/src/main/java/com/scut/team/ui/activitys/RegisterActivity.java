package com.scut.team.ui.activitys;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.scut.team.R;
import com.scut.team.model.User;
import com.scut.team.ui.base.BasePageActivity;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by host on 2016/1/3.
 * this is for new user to register
 */
public class RegisterActivity extends BasePageActivity {

    private EditText mUsername;
    private EditText mMail;
    private EditText mPassword;
    private Button mComfirm;
    private TextView mCancel;

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void findViews() {
        mUsername = (EditText) findViewById(R.id.register_et_username);
        mMail = (EditText) findViewById(R.id.register_et_mail);
        mPassword = (EditText) findViewById(R.id.register_et_password);
        mComfirm = (Button) findViewById(R.id.register_btn_confirm);
        mCancel = (TextView) findViewById(R.id.register_tv_cancel);
    }

    @Override
    protected void setListener() {
        mComfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mComfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String username = mUsername.getText().toString();
                        String mail = mMail.getText().toString();
                        String password = mPassword.getText().toString();
                        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(mail)||TextUtils.isEmpty(password)){
                            //do not allow the empty String of mail or password
                            return;
                        }
                        User user = new User();
                        user.setUsername(username);
                        user.setEmail(mail);
                        user.setPassword(password);
                        user.save(getBaseContext(), new SaveListener() {
                            @Override
                            public void onSuccess() {
                                showToast("注册成功");
                                finish();
                                redirectToActivity(getBaseContext(),LoginActivity.class);
                            }

                            @Override
                            public void onFailure(int i, String s) {
                                showToast("注册失败，请稍后重试");
                            }
                        });
                    }
                });
            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
