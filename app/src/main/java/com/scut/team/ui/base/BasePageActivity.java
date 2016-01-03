package com.scut.team.ui.base;

import android.os.Bundle;

/**
 * 页面类型Activity的基类(不要再自己去重写onCreate函数,为了代码风格的一致)
 * 页面类型的基类继承自该基类!!!
 *
 * Created by jay on 16/1/2.
 */
public abstract class BasePageActivity extends BaseActivity{
    protected Bundle mBundle;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mBundle = getIntent().getExtras();
        setLayoutView();
        init(bundle);
    }

    private void init(Bundle bundle) {
        findViews();
        setupViews(bundle);
        setListener();
        fetchData();
    }

    /**
     * setContentView 等操作在这里调用
     */
    protected abstract void setLayoutView();

    /**
     * findViewById 等操作在这里调用(重写该方法)
     */
    protected void findViews(){}

    /**
     * 设置View的相关信息在这里调用(重写该方法)
     * @param bundle Bundle信息
     */
    protected void setupViews(Bundle bundle){}

    /**
     * 设置监听(重写该方法)
     */
    protected void setListener(){}

    /**
     * 需要获取一些数据然后在界面上显示的操作在这里进行(重写该方法)
     */
    protected void fetchData(){}
}
