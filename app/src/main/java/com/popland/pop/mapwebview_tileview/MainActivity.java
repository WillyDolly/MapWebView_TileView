package com.popland.pop.mapwebview_tileview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView)findViewById(R.id.webView);

        //webView.setInitialScale(1);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setLoadWithOverviewMode(true);//zoom farthest out to show entire image
        webView.getSettings().setUseWideViewPort(true);//create wide area to draw WebPage
        webView.getSettings().setBuiltInZoomControls(true);

        initialApp();
    }

    public void initialApp(){
        webView.loadUrl("file:///android_asset/CampusMap1.html");
    }
}
