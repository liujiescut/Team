package com.scut.team.Synchronized;

/**
 * Created by host on 2016/1/4.
 * 网络回调接口
 */
public interface NetworkCallbackListener {
    void onSuccess(String response);

    void onFail(String error);
}
