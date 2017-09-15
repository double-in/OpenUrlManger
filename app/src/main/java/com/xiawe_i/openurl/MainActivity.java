package com.xiawe_i.openurl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.xiawe_i.openurl.openurl.OpenUrlManager;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] URL = {
            "internal://recharge:8080/test?needLogin=1&name=recharge",
            "internal://orderDetail:8080/test?needLogin=1&name=orderDetail",
            "internal://cardList:8080/test?needLogin=1&name=cardList",
            "internal://voucherList:8080/test?needLogin=1&name=voucherList",
            "http://192.168.0.1:8080/h5/?needLogin=0&name=web/demo.html"
    };
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = getURL();
        ((TextView) findViewById(R.id.textView)).setText(url.trim());
    }

    public void onClick(View view) {
        OpenUrlManager.openUrl(url, this);
    }


    public void random(View view) {
        url = getURL();
        ((TextView) findViewById(R.id.textView)).setText(url.trim());
    }

    private String getURL() {
        int max = 5;
        int min = 0;
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return URL[s];
    }
}
