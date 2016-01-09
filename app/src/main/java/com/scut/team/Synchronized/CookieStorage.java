package com.scut.team.Synchronized;

import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.scut.team.utils.LogUtils;
import com.scut.team.utils.SpUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by host on 2016/1/4.
 * 为了登录成功后捕获并存储cookies，作为网络连接的令牌
 */
public class CookieStorage extends StringRequest {
    private String mHeader;
    public String cookieFromResponse;
    private Context context;

    public CookieStorage(int method, Context context, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        this.context = context;
    }

    public CookieStorage(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    /**
     *
     * @param response http返回的响应
     * @return 返回字符串类型的回调响应
     */
    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        mHeader = response.headers.toString();
        LogUtils.i("LOG", "get headers in parseNetworkResponse " + response.headers.toString());
        //使用正则表达式从reponse的头中提取cookie内容的子串
        Pattern pattern = Pattern.compile("Set-Cookie.*?;");
        Matcher m = pattern.matcher(mHeader);
        if (m.find()) {
            cookieFromResponse = m.group();
            LogUtils.i("LOG", "cookie from server " + cookieFromResponse);
            //去掉cookie末尾的分号
            cookieFromResponse = cookieFromResponse.substring(11, cookieFromResponse.length() - 1);
            LogUtils.i("LOG", "cookie substring " + cookieFromResponse);

            SpUtils spUtils = new SpUtils(context);
            spUtils.setValue("sess", cookieFromResponse);
        }


        String str = null;
        try {
            str = new String(response.data, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(response));
    }
}
