package com.xiawe_i.openurl.openurl;

import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;

import com.xiawe_i.openurl.App;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;


/**
 * Created by xiawe_i on 2017/9/14.
 */

public class OpenUrlContextFactory {

    private static JSONObject schemeMap;

    public static OpenUrlContext contextWithURL(String url) {
        try {
            Uri uri = Uri.parse(url);
            Log.e("OpenUrlContextFactory ", "contextWithURL:path  " + uri.getPath());
            switch (uri.getScheme()) {
                case "http":
                case "https":
                    return new WebOpenUrlContext(url);
                case OpenUrlManager.NATIVE_SCHEME:
                    if (schemeMap == null) {
                        AssetManager assetManager = App.getInstance().getAssets();
                        InputStream is = assetManager.open(OpenUrlManager.NATIVE_SCHEME_CONFIG);
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        StringBuilder stringBuilder = new StringBuilder();
                        String str;
                        while ((str = br.readLine()) != null) {
                            stringBuilder.append(str);
                        }
                        schemeMap = new JSONObject(stringBuilder.toString());
                    }

                    if (schemeMap.has(uri.getHost())) {
                        JSONObject schemeObject = schemeMap.getJSONObject(uri.getHost());
                        Class openUrlContextClass = Class.forName(schemeObject.getString("openUrlContext"));
                        Constructor constructor = openUrlContextClass.getConstructor(String.class, Class.class, boolean.class);
                        return (OpenUrlContext) constructor.newInstance(url, Class.forName(schemeObject.getString("uiClass")), schemeObject.getBoolean("needLogin"));
                    }
                    return null;
                default:
                    return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
