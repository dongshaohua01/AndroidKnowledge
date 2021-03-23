package com.cmcc.androidknowledge.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.cmcc.androidknowledge.R;

public class WebViewActivity extends AppCompatActivity {

    private View mCustomView;
    private int scy = 0;
    private int lastHeight = 0;

    private FrameLayout mFrameLayout;
    private SHWebView mWebView;
    private InsideWebChromeClient mInsideWebChromeClient;
    //private JavascriptInterface javascriptInterface;
    private String URL = "";

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 2
        mFrameLayout = (FrameLayout) findViewById(R.id.mFrameLayout);
        mWebView = (SHWebView) findViewById(R.id.mWebView);
        // 3
        initWebView();
        mWebView.loadUrl(URL);

        Log.e("xxx", "onCreate===========");

        mWebView.setOnScrollListener(new SHWebView.IScrollListener() {
            @Override
            public void onScrollChanged(int scrollY) {
                int lastscrollY = mWebView.getHeight() + mWebView.getScrollY();
                scy = lastscrollY;
                Log.i("xxx", lastscrollY + "：scrollY高度");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("xxx", "onStart===========");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("xxx", "onResume===========");

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("xxx", "onPause===========");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("xxx", "onStop===========");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("xxx", "onDestroy===========");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("xxx", "onRestart===========");
    }

    private void initWebView() {
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        //settings.setPluginsEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        mInsideWebChromeClient = new InsideWebChromeClient();
        mWebView.setWebChromeClient(mInsideWebChromeClient);
//        InsideWebViewClient mInsideWebViewClient = new InsideWebViewClient();
        //javascriptInterface = new JavascriptInterface();
        //mWebView.addJavascriptInterface(javascriptInterface, "java2js_laole918");
//        mWebView.setWebViewClient(mInsideWebViewClient);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });


    }

    /**
     * 全屏容器界面
     */
    static class FullscreenHolder extends FrameLayout {

        public FullscreenHolder(Context ctx) {
            super(ctx);
            setBackgroundColor(ctx.getResources().getColor(android.R.color.black));
        }

        @Override
        public boolean onTouchEvent(MotionEvent evt) {
            return true;
        }
    }

    private class InsideWebChromeClient extends WebChromeClient {

        private CustomViewCallback mCustomViewCallback;
        private FullscreenHolder fullscreenContainer;


        @SuppressLint("SourceLockedOrientationActivity")
        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            super.onShowCustomView(view, callback);
            if (mCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }


            WebViewActivity.this.getWindow().getDecorView();
            FrameLayout decor = (FrameLayout) getWindow().getDecorView();
            fullscreenContainer = new FullscreenHolder(WebViewActivity.this);
            fullscreenContainer.addView(view);
            decor.addView(fullscreenContainer);


            mCustomView = view;
//            mFrameLayout.addView(mCustomView);
            mCustomViewCallback = callback;
            mWebView.setVisibility(View.GONE);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        public void onHideCustomView() {
            mWebView.setVisibility(View.VISIBLE);
            if (mCustomView == null) {
                return;
            }
            FrameLayout decor = (FrameLayout) getWindow().getDecorView();
            decor.removeView(fullscreenContainer);
            fullscreenContainer = null;


            mCustomView.setVisibility(View.GONE);
            mFrameLayout.removeView(mCustomView);
            mCustomView = null;
            try {
                mCustomViewCallback.onCustomViewHidden();
            } catch (Exception e) {
            }
            mWebView.scrollTo(0, lastHeight);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            super.onHideCustomView();
        }
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration config) {
        super.onConfigurationChanged(config);
        switch (config.orientation) {
            case Configuration.ORIENTATION_LANDSCAPE:

                Log.e("xxx", scy + "");

                if (!flag) {
                    lastHeight = scy;
                    flag = true;
                }

                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

                break;
            case Configuration.ORIENTATION_PORTRAIT:
                Log.e("xxx", lastHeight + "小屏");
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                mWebView.scrollTo(0, lastHeight);
                break;
        }
    }
}