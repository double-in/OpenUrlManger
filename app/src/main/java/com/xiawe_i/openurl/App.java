package com.xiawe_i.openurl;

import android.app.Application;
import android.content.Context;

/**
 * Created by xiawe_i on 2017/9/14.
 */

public class App extends Application {


    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getInstance() {
        return mContext;
    }
}
