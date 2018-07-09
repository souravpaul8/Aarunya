package com.arunya.aarunya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class news extends AppCompatActivity {

    WebView webview;
    String url = "http://hindi.krishijagran.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        webview = (WebView) findViewById(R.id.webview1);
        webview.setWebViewClient(new WebViewClient());

        webview.getSettings().getLoadsImagesAutomatically();
        webview.getSettings().setJavaScriptEnabled(true);
        //webview.getScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webview.loadUrl(url);


    }
}