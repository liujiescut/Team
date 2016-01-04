package com.scut.team.Synchronized;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.scut.team.utils.LogUtils;
import com.scut.team.utils.SpUtils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * request with cookies header
 * Created by gz on 15/9/1.
 */
public class StringRequest8 extends StringRequest {
    private Context context;

    public StringRequest8(int method, Context context, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        this.context = context;
    }

    public StringRequest8(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String str = null;
        try {
            str = new String(response.data, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Response.success(str, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> header = new HashMap<>();
        String cookieFromResponse;
        SpUtils spUtils = new SpUtils(context);
        cookieFromResponse = spUtils.getValue("sess", null);
        try {
            if (cookieFromResponse != null && cookieFromResponse.length() != 0) {
                cookieFromResponse = cookieFromResponse.replace("\u003d", "=");
                LogUtils.i("replace string", cookieFromResponse);
                header.put("Cookie", cookieFromResponse);
                LogUtils.i("send header", header.toString());
            }
            return header;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
