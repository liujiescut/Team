package com.scut.team.utils;

import android.app.Activity;

import java.util.ArrayList;

/**
 * 管理Activity的工具类
 */
public class ActivityUtils {
    /** Activity栈 */
    private ArrayList<Activity> activityList = new ArrayList<>();

    /** 工具类单例 */
    private static ActivityUtils sInstance;

    public static ActivityUtils getInstance() {
        if (null == sInstance) {
            sInstance = new ActivityUtils();
        }
        return sInstance;
    }

    private ActivityUtils() {}

    /**
     * 获取栈顶Activity
     * @return 栈顶Activity
     */
    public synchronized Activity getTopActivity() {
        return activityList.get(activityList.size() - 1);
    }

    /**
     * 往 Activity栈 中添加一个 Activity
     * @param ac 要添加的Activity
     */
    public synchronized void addActivity(Activity ac) {
        activityList.add(ac);
    }

    /**
     * 移除 Activity栈 中的Activity
     * @param ac 要移除的Activity
     */
    public synchronized void removeActivity(Activity ac) {
        activityList.remove(ac);
    }

    /**
     * 移除 Activity栈 中所有的额Activity
     */
    public synchronized void removeAllActivity() {
        for (Activity ac : activityList) {
            if (null != ac) {
                if (!ac.isFinishing()) {
                    ac.finish();
                }
                ac = null;
            }
        }
        activityList.clear();
    }
}
