package com.fll.comicreader.comicreader;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class MainActivity extends ActionBarActivity {

    private ContentParser contentParser = new ContentParser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        WebView myWebView = (WebView) findViewById(R.id.webview);
//        myWebView.loadUrl("http://3gmanhua.com");
        test();
    }

    private void test(){
        new Thread(){
            @Override
            public void run() {
                String result = contentParser.posturl("http://3gmanhua.com/vols/28819_228468/");
                Log.e("aaaaa", result);
            }
        }.start();

    }
}
