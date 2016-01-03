package com.scut.team.app;

import android.app.Application;
import android.content.Context;

import com.scut.team.utils.ActivityUtils;
import com.scut.team.utils.SpUtils;

import cn.bmob.v3.Bmob;

/**
 * 自定义Application类
 *
 * Created by jay on 16/1/2.
 */
public class App extends Application{
    /** Application单例 */
    private static App sInstance;

    /** SpUtils对象(整个应用务必使用这个SpUtils) */
    public static SpUtils sSpUtils;

    /** 空构造函数(勿删) */
    public App(){}

    @Override
    public void onCreate() {
        super.onCreate();
        if(null == sSpUtils){
            sSpUtils = new SpUtils(this, GlobalConstant.Sp.PRE_NAME);
        }

        init();
    }

    /**
     * 初始化Sdk等操作
     */
    private void init(){
        Bmob.initialize(this, GlobalConstant.Config.BMOB_APPLICATION_ID);
    }

    /**
     * 获取 Application单例
     * @return Application
     */
    public static App getApp(){
        if(null == sInstance){
            sInstance = new App();
        }

        return sInstance;
    }

    /**
     * 获取SpUtils
     * @return SpUtils对象
     */
    public SpUtils getSpUtils(){
        if(null == sSpUtils){
            sSpUtils = new SpUtils(this, GlobalConstant.Sp.PRE_NAME);
        }

        return sSpUtils;
    }

    /**
     * 获取应用上下文
     *
     * 如果不需要用Activity的一律用这个Context!!!(避免一些莫名奇妙的内存泄漏)
     * @return 应用上下文
     */
    public Context getContext(){
        return getApp().getApplicationContext();
    }

    /**
     * 退出应用时调用该函数清空 Activity栈
     */
    public static void exit(){
        ActivityUtils.getInstance().removeAllActivity();
    }
}
