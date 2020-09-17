package net.lishaoy.webview.webChromeClient;

import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import net.lishaoy.webview.WebViewCallBack;

public class CustomWebChromeClient extends WebChromeClient {
    
    private WebViewCallBack webViewCallBack;
    private static final String TAG = "CustomWebChromeClient";

    public CustomWebChromeClient(WebViewCallBack webViewCallBack) {
        this.webViewCallBack = webViewCallBack;
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        if (webViewCallBack != null) {
            webViewCallBack.updateTitle(title);
        } else {
            Log.e(TAG, "onReceivedTitle: WebViewCallBack is null");
        }
    }
}
