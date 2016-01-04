package com.scut.team.ui.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.scut.team.R;
import com.scut.team.ui.base.BasePageActivity;

/**
 * Created by host on 2016/1/4.
 * the splash activity for first use the application
 */
public class SplashActivity extends BasePageActivity {

    private ImageView mMain;
    private Button mRegister;
    private Button mLogin;

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void findViews() {
        mMain = (ImageView) findViewById(R.id.splash_iv_main);
        mRegister = (Button) findViewById(R.id.splash_btn_register);
        mLogin = (Button) findViewById(R.id.splash_btn_login);
    }

    @Override
    protected void setListener() {
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                redirectToActivity(getBaseContext(),RegisterActivity.class);
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               redirectToActivity(getBaseContext(),LoginActivity.class);
            }
        });
    }
}
