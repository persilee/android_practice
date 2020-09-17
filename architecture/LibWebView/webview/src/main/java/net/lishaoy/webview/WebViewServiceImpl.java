package net.lishaoy.webview;

import android.content.Context;
import android.content.Intent;

import com.google.auto.service.AutoService;

import net.lishaoy.common.autoservice.IWebViewService;
import net.lishaoy.webview.utils.Constants;

@AutoService({IWebViewService.class})
public class WebViewServiceImpl implements IWebViewService {

    @Override
    public void openWebView(Context context, String url, String title, boolean isShowTopBar) {
        if (context != null) {
            Intent intent = new Intent(context, WebViewActivity.class);
            intent.putExtra(Constants.URL, url);
            intent.putExtra(Constants.TITLE, title);
            intent.putExtra(Constants.IS_SHOW_TOP_BAR, isShowTopBar);
            context.startActivity(intent);
        }
    }
}
