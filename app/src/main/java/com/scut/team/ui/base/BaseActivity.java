package com.scut.team.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.scut.team.app.App;
import com.scut.team.utils.ActivityUtils;
import com.scut.team.utils.SpUtils;

/**
 * Activity基类(所有Activity必须继承自此基类!!!)
 * 要用到基类中已经提供的资源时务必直接使用基类资源,而不是重新获取(比如mApp等)
 *
 * Created by jay on 16/1/2.
 */
public class BaseActivity extends Activity{
    /** Activity Tag标签 */
    protected String mTag;

    /** Application的引用 */
    protected App mApp;

    /** ApUtils的引用 */
    protected SpUtils mSpUtils;

    /** Activity上下文 */
    protected Activity mActivity;

    /** Resources对象 */
    protected Resources mResources;

    /** Toast对象 */
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initConfigs();
        ActivityUtils.getInstance().addActivity(mActivity);
    }

    /**
     * 初始化引用
     */
    private void initConfigs(){
        mTag = getClass().getName();
        mApp = App.getApp();
        mSpUtils = mApp.getSpUtils();
        mActivity = this;
        mResources = getResources();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtils.getInstance().removeActivity(mActivity);
    }

    /**
     * Activity跳转
     *
     * @param context           上下文
     * @param targetActivity    目的Activity
     * @param bundle            传输的数据
     */
    public void redirectToActivity(Context context, Class<?> targetActivity, Bundle bundle) {
        Intent intent = new Intent(context, targetActivity);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * Activity跳转
     *
     * @param context           上下文
     * @param targetActivity    目的Activity
     */
    public void redirectToActivity(Context context, Class<?> targetActivity) {
        redirectToActivity(context, targetActivity, null);
    }

    /**
     * 显示Toast全部使用这个函数!!!
     * @param text 要Toast的信息
     */
    public void showToast(final String text) {
        if (!TextUtils.isEmpty(text)) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mToast == null) {
                        mToast = Toast.makeText(mActivity, text,
                                Toast.LENGTH_SHORT);
                    } else {
                        mToast.setText(text);
                    }
                    mToast.show();
                }
            });
        }
    }
}
