package com.xiawe_i.openurl.openurl;

import android.content.Context;

import com.xiawe_i.openurl.activity.WebPageActivity;

/**
 * Created by xiawe_i on 2017/9/14.
 */
public class WebOpenUrlContext extends OpenUrlContext{

    public WebOpenUrlContext(String url) {
        super(url, WebPageActivity.class, false);
    }

    @Override
    protected void jump(Context context) {
//        intent.putExtra(WebPageActivity.WEBURL_EXTRA_KEY, url);
//        intent.putExtra(WebPageActivity.SHOWSHARE_EXTRA_KEY, true);
        context.startActivity(intent);
    }
}
