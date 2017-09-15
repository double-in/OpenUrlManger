package com.xiawe_i.openurl.openurl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiawe_i on 2017/9/14.
 */

public class OpenUrlContext {
    public static final String TAG = OpenUrlContext.class.getName();

    public static final String OPENURL_PARAMS_KEY = "OPENURL_PARAMS_KEY";

    public static final String NEEDSLOGIN_PARAMS = "needLogin";

    protected String url;

    protected Class uiClass;

    protected boolean needLogin;

    protected Map<String, String> urlParams;

    protected Intent intent;

    public OpenUrlContext(String url, Class uiClass, boolean needLogin) {
        this.url = url;
        this.uiClass = uiClass;
        this.needLogin = needLogin;
        parseParams();
    }

    protected void startContext(Context context) {
        if (verifyParams()) {
            buildIntent(context);
            jump(context);
        } else {
            Log.e(TAG, url);
        }
    }

    protected void parseParams() {
        urlParams = new HashMap<>();
        Uri uri = Uri.parse(url);
        for (String key : uri.getQueryParameterNames()) {
            urlParams.put(key, uri.getQueryParameter(key));
            if (key.equals(NEEDSLOGIN_PARAMS)) {
                if (uri.getQueryParameter(key).equals("1")) {
                    needLogin = true;
                } else if (uri.getQueryParameter(key).equals("0")) {
                    needLogin = false;
                }
            }
        }
    }

    protected boolean verifyParams() {
        return true;
    }

    protected void buildIntent(Context context) {
        intent = new Intent(context, uiClass);

        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : urlParams.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        intent.putExtra(OPENURL_PARAMS_KEY, bundle);
    }

    protected void jump(Context context) {
        context.startActivity(intent);
    }
}
