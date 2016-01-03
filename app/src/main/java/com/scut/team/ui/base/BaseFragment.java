package com.scut.team.ui.base;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Fragment的基类(暂时还没有什么实现,但是为了后面修改容易还是全部必须继承该基类)
 * 所有Fragment必须继承自该基类!!!
 * <p/>
 * Created by jay on 16/1/2.
 */
public class BaseFragment extends Fragment {
    /**
     * Toast对象
     */
    private Toast mToast;

    /**
     * Activity跳转
     *
     * @param context        上下文
     * @param targetActivity 目的Activity
     * @param bundle         传输的数据
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
     * @param context        上下文
     * @param targetActivity 目的Activity
     */
    public void redirectToActivity(Context context, Class<?> targetActivity) {
        redirectToActivity(context, targetActivity, null);
    }

    /**
     * 显示Toast全部使用这个函数!!!
     *
     * @param text 要Toast的信息
     */
    public void showToast(final String text) {
        if (TextUtils.isEmpty(text) || null == getActivity()) {
            return;
        }

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mToast == null) {
                    mToast = Toast.makeText(getActivity(), text,
                            Toast.LENGTH_SHORT);
                } else {
                    mToast.setText(text);
                }
                mToast.show();
            }
        });

    }
}
