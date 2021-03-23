package com.cmcc.androidknowledge.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * @author: zwj
 * @date: 2020/7/11
 */
public class SHWebView extends WebView {

    public SHWebView(Context context) {
        super(context);
    }

    public SHWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SHWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mScrollListener != null) {
            mScrollListener.onScrollChanged(t);
        }
    }

    public interface IScrollListener {
        void onScrollChanged(int scrollY);
    }

    private IScrollListener mScrollListener;

    public void setOnScrollListener(IScrollListener listener) {
        mScrollListener = listener;
    }
}
