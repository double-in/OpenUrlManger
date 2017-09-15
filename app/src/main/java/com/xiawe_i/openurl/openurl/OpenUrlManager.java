package com.xiawe_i.openurl.openurl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.xiawe_i.openurl.Util;

/**
 * Created by xiawe_i on 2017/9/14.
 */

public class OpenUrlManager {
    private static final String TAG = "OpenUrlManager";
    public static final String NATIVE_SCHEME_CONFIG = "openurl.json";
    public static final String NATIVE_SCHEME = "internal";

    public static void openUrl(String url, Context context) {
        OpenUrlContext openUrlContext = OpenUrlContextFactory.contextWithURL(url);
        if (openUrlContext != null) {
            if (openUrlContext.needLogin && TextUtils.isEmpty(Util.getToke())) {
                // TODO: 2017/9/15 需要登录
                // LoginManager.getInstance().launchLoginActivity(context);
                Log.e(TAG, "openUrl: 需要登录");
            } else {
                openUrlContext.startContext(context);
            }
        }
    }
}
