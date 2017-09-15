package com.xiawe_i.openurl.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.xiawe_i.openurl.R;
import com.xiawe_i.openurl.openurl.OpenUrlContext;

/**
 * Created by xiawe_i on 2017/9/14.
 */

public class VoucherListActivity extends BaseActivity {

    private static final String TAG = "VoucherListActivity";

    @Override
    public int getLayoutId() {
        return R.layout.activity_common;
    }

    @Override
    protected void initViews() {
        if (getIntent() != null) {
            Bundle bundleExtra = getIntent().getBundleExtra(OpenUrlContext.OPENURL_PARAMS_KEY);
            String string = bundleExtra.getString("name");
            ((TextView) findViewById(R.id.tv_content)).setText(TAG + "\n" + string);
        }
    }

}