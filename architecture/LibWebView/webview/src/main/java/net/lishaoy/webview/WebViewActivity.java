package net.lishaoy.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import net.lishaoy.webview.databinding.ActivityWebViewBinding;
import net.lishaoy.webview.utils.Constants;

public class WebViewActivity extends AppCompatActivity {

    private ActivityWebViewBinding webViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_web_view);
        webViewBinding.webview.getSettings().setJavaScriptEnabled(true);
        webViewBinding.webview.getSettings().setAllowContentAccess(true);
        webViewBinding.webview.getSettings().setAllowFileAccess(true);
        webViewBinding.webview.loadUrl(getIntent().getStringExtra(Constants.URL));
        webViewBinding.webviewTopBar.setTitle(getIntent().getStringExtra(Constants.TITLE));
        webViewBinding.webviewTopBar.setVisibility(getIntent().getBooleanExtra(Constants.IS_SHOW_TOP_BAR, true) ? View.VISIBLE : View.GONE);
        webViewBinding.webviewTopBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebViewActivity.this.finish();
            }
        });
    }
}