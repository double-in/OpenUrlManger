package com.xiawe_i.openurl.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by xiawe_i on 2017/9/15.
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initViews();
    }

    protected abstract void initViews();

    protected abstract int getLayoutId();
}
