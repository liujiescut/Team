package com.scut.team.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.scut.team.app.GlobalConstant;
import com.orhanobut.logger.Logger;


/**
 * @author kingofglory
 *         email: kingofglory@yeah.net
 *         blog:  http:www.google.com
 * @date 2014-2-21
 * TODO Log工具类，设置开关，防止发布版本时log信息泄露
 */
public class LogUtils {

    private static final boolean SHOW = GlobalConstant.Config.IS_DEBUG || GlobalConstant.Config.IS_LOG;

    private static final String DEFAULT_TAG = GlobalConstant.Config.LOG_TAG;


    private static void init() {
        init(DEFAULT_TAG);
    }

    private static void init(String tag) {
        Logger.init(tag)
                .setMethodOffset(1)
                .setMethodCount(2);
    }

    public static void i(String message) {
        i(message, false);
    }

    public static void i(String tag, String message) {
        i(message, false, tag);
    }

    public static void i(String message, boolean traceable, Object... args) {
        if (SHOW) {
            if (traceable) {
                init();
                Logger.i(message, args);
            } else if (args == null || args.length == 0)
                Log.i(DEFAULT_TAG, message);
            else
                Log.i(args[0].toString(), message);
        }
    }

    public static void i(String tag, String message, boolean traceable, Object... args) {
        if (SHOW) {
            if (traceable) {
                init(tag);
                Logger.i(message, args);
            } else {
                Log.i(tag, message);
            }
        }
    }

    public static void d(String message) {
        d(message, false);
    }

    public static void d(String tag, String message) {
        d(message, false, tag);
    }

    public static void d(String message, boolean traceable, Object... args) {
        if (SHOW) {
            if (traceable) {
                init();
                Logger.d(message, args);
            } else if (args == null || args.length == 0)
                Log.d(DEFAULT_TAG, message);
            else
                Log.d(args[0].toString(), message);
        }
    }

    public static void d(String tag, String message, boolean traceable, Object... args) {
        if (SHOW) {
            if (traceable) {
                init(tag);
                Logger.d(message, args);
            } else {
                Log.d(tag, message);
            }
        }
    }

    public static void w(String message) {
        w(message, false);
    }

    public static void w(String tag, String message) {
        w(message, false, tag);
    }

    public static void w(String message, boolean traceable, Object... args) {
        if (SHOW) {
            if (traceable) {
                init();
                Logger.w(message, args);
            } else if (args == null || args.length == 0)
                Log.w(DEFAULT_TAG, message);
            else
                Log.w(args[0].toString(), message);
        }
    }

    public static void w(String tag, String message, boolean traceable, Object... args) {
        if (SHOW) {
            if (traceable) {
                init(tag);
                Logger.w(message, args);
            } else {
                Log.w(tag, message);
            }
        }
    }

    public static void e(String message) {
        e(message, false);
    }

    public static void e(String tag, String message) {
        e(message, false, tag);
    }

    public static void e(String message, boolean traceable, Object... args) {
        if (SHOW) {
            if (traceable) {
                init();
                Logger.e(message, args);
            } else if (args == null || args.length == 0)
                Log.e(DEFAULT_TAG, message);
            else
                Log.e(args[0].toString(), message);
        }
    }

    public static void e(String tag, String message, boolean traceable, Object... args) {
        if (SHOW) {
            if (traceable) {
                init(tag);
                Logger.e(message, args);
            } else {
                Log.e(tag, message);
            }
        }
    }

    public static void json(String json) {
        if (SHOW) {
            init();
            Logger.json(json);
        }
    }

    public static void json(String tag, String json) {
        if (SHOW) {
            init(tag);
            Logger.json(json);
        }
    }

    public static void xml(String xml) {
        if (SHOW) {
            init();
            Logger.xml(xml);
        }
    }

    public static void xml(String tag, String xml) {
        if (SHOW) {
            init(tag);
            Logger.xml(xml);
        }
    }

    public static void forcePrint(String msg) {
            Log.i(GlobalConstant.Config.LOG_TAG, msg);
    }

    public static void toastError(Context context, String msg){
        if(GlobalConstant.Config.IS_TOAST){
            Toast.makeText(context, "操作失败 :" + msg, Toast.LENGTH_SHORT).show();
        }
    }

    public static void toast(Context context, String msg){
        if(GlobalConstant.Config.IS_TOAST){
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

}
