package com.scut.team.ui.activitys;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.scut.team.R;
import com.scut.team.model.User;
import com.scut.team.ui.base.BasePageActivity;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by gz on 2016/1/3.
 * use for login to bmob
 */
public class LoginActivity extends BasePageActivity {
    private EditText mMail;
    private EditText mPassword;
    private Button mComfirm;

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void findViews() {
        mMail = (EditText) findViewById(R.id.login_et_mail);
        mPassword = (EditText) findViewById(R.id.login_et_password);
        mComfirm = (Button) findViewById(R.id.login_btn_comfirm);
    }

    @Override
    protected void setListener() {
        //set the listener of the confirm button
        //so that can login
        mComfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = mMail.getText().toString();
                String password = mPassword.getText().toString();
                if(TextUtils.isEmpty(mail)||TextUtils.isEmpty(password)){
                    //do not allow the empty String of mail or password
                    return;
                }
                User user = new User();
                user.setEmail(mail);
                user.setPassword(password);
                user.login(LoginActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        redirectToActivity(LoginActivity.this,MainActivity.class);
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        showToast("邮箱或密码错误");
                    }
                });
            }
        });
    }
}
