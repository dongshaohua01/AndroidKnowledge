package com.cmcc.androidknowledge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.i("tag-->","B --- onCreate()");
        WebView webview = (WebView)findViewById(R.id.webview);

        webview.loadUrl("file:///android_asset/index.html");
        //支持App内部javascript交互
        webview.getSettings().setJavaScriptEnabled(true);
         //自适应屏幕
//        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        webview.getSettings().setLoadWithOverviewMode(true);
//          //设置可以支持缩放
//          webview.getSettings().setSupportZoom(true);
//          //扩大比例的缩放
//         webview.getSettings().setUseWideViewPort(true);
//          //设置是否出现缩放工具
//          webview.getSettings().setBuiltInZoomControls(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("tag-->","B --- onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("tag-->","B --- onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("tag-->","B --- onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("tag-->","B --- onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("tag-->","B --- onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("tag-->","B --- onDestroy()");
    }
}
