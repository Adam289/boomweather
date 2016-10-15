package com.ming.boomweather.util;

/**
 * Created by temp on 2016/10/15.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
