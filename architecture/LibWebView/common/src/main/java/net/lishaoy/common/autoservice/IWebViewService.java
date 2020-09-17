package net.lishaoy.common.autoservice;

import android.content.Context;

public interface IWebViewService {
    void openWebView(Context context, String url, String title, boolean isShowTopBar);
}
