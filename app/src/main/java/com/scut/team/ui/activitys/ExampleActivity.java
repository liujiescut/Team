package com.scut.team.ui.activitys;

import android.view.View;
import android.widget.Button;

import com.scut.team.R;
import com.scut.team.ui.base.BasePageActivity;

/**
 * 用于演示的Activity
 */
public class ExampleActivity extends BasePageActivity implements View.OnClickListener {
    private Button mTestButton;

    @Override
    protected void setLayoutView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void findViews() {
        mTestButton = (Button) findViewById(R.id.example_btn_click_me);
    }

    @Override
    protected void setListener() {
        mTestButton.setOnClickListener(this);
    }

    @Override
    protected void fetchData() {
        mTestButton.setText("点我");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.example_btn_click_me:
                showToast("我是测试点击的按钮");

            default:
                break;
        }
    }
}
