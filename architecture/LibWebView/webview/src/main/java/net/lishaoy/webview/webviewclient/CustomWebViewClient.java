package net.lishaoy.webview.webviewclient;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.lishaoy.webview.WebViewCallBack;

public class CustomWebViewClient extends WebViewClient {

    private WebViewCallBack webViewCallBack;
    private static final String TAG = "CustomWebViewClient";

    public CustomWebViewClient(WebViewCallBack webViewCallBack) {
        this.webViewCallBack = webViewCallBack;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if (webViewCallBack != null) {
            webViewCallBack.pageStarted(url);
        }else {
            Log.e(TAG, "onPageStarted: WebViewCallBack is null");
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if (webViewCallBack != null) {
            webViewCallBack.pageFinished(url);
        }else {
            Log.e(TAG, "onPageStarted: WebViewCallBack is null");
        }
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        if (webViewCallBack != null) {
            webViewCallBack.onError();
        }else {
            Log.e(TAG, "onPageStarted: WebViewCallBack is null");
        }
    }
}
