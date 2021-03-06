package com.tir38.android.androidtvdemo.forealz;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tir38.android.androidtvdemo.R;

import java.net.URL;

public class WebViewActivity extends Activity {

    public static final String EXTRA_URL = "WebViewActivity.EXTRA_URL";
    WebView mWebView;
    private URL mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        mWebView = (WebView) findViewById(R.id.activity_webview_webview);

        mUrl = (URL) getIntent().getSerializableExtra(EXTRA_URL);

        if (mUrl != null) {
            mWebView.getSettings().setJavaScriptEnabled(true);

            mWebView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return false;
                }
            });

            mWebView.loadUrl(mUrl.toString());
        }
    }
}
