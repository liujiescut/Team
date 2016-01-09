package com.scut.team.Synchronized;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.scut.team.utils.LogUtils;

import java.util.Map;

/**
 * Created by host on 2016/1/4.
 * 发起http协议网络请求，封装第三方包volley
 */
public class HttpHelper {
    private static RequestQueue mQueue;
    private static boolean isInit = false;
    private static Context context;

    public static RequestQueue getmQueue() throws Exception {
        if (isInit) {
            return mQueue;
        } else {
            throw new Exception("volley has not init");
        }
    }

    public static void init(Context context) {
        mQueue = Volley.newRequestQueue(context);
        HttpHelper.context = context;
        isInit = true;
    }

    public static void post(String httpurl, final Map<String, String> params, final NetworkCallbackListener networkCallbackListener) {
        StringRequest stringRequest = new StringRequest8(Request.Method.POST, HttpHelper.context, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        LogUtils.i("volley", "response -> " + response);
                        networkCallbackListener.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.i("volley error", error.getMessage() + "");
                networkCallbackListener.onFail(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                //在这里设置需要post的参数
                return params;
            }
        };
        mQueue.add(stringRequest);
    }

    public static void put(String httpurl, final Map<String, String> params, final NetworkCallbackListener networkCallbackListener) {
        StringRequest stringRequest = new StringRequest8(Request.Method.PUT, HttpHelper.context, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        LogUtils.i("volley", "response -> " + response);
                        networkCallbackListener.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.i("volley error", error.getMessage() + "");
                networkCallbackListener.onFail(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                //在这里设置需要post的参数
                return params;
            }
        };
        mQueue.add(stringRequest);
    }

    public static void delete(String httpurl, final Map<String, String> params, final NetworkCallbackListener networkCallbackListener) {
        httpurl += "?";
        for (Map.Entry<String, String> entry : params.entrySet()) {
            httpurl += entry.getKey() + "=" + entry.getValue();
        }
        StringRequest stringRequest = new StringRequest8(Request.Method.DELETE, HttpHelper.context, httpurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        LogUtils.i("volley", "response -> " + response);
                        networkCallbackListener.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.i("volley error", error.getMessage() + "");
                networkCallbackListener.onFail(error.getMessage());
            }
        });
        mQueue.add(stringRequest);
    }

    public static void get(int order, final NetworkCallbackListener networkCallbackListener) {
        String url ="192.168.1.102"+ "?orders=" + order;
        StringRequest stringRequest = new StringRequest8(Request.Method.GET, HttpHelper.context, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        LogUtils.i("volley", "response -> " + response);
                        networkCallbackListener.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.i("volley error", error.getMessage() + "");
                networkCallbackListener.onFail(error.getMessage());
            }
        });
        mQueue.add(stringRequest);
    }

    public static void login(final Map<String, String> params, final NetworkCallbackListener networkCallbackListener) {
        StringRequest stringRequest = new CookieStorage(Request.Method.POST, HttpHelper.context, "192.168.1.102",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        LogUtils.i("volley", "response -> " + response);
                        networkCallbackListener.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LogUtils.i("volley error", error.getMessage() + "");
                networkCallbackListener.onFail(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                //在这里设置需要post的参数
                return params;
            }
        };
        mQueue.add(stringRequest);
    }
}
