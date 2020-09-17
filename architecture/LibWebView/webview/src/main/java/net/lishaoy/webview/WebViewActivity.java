package net.lishaoy.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        webViewBinding.webviewTopBar.setTitle(getIntent().getStringExtra(Constants.TITLE));
        webViewBinding.webviewTopBar.setVisibility(getIntent().getBooleanExtra(Constants.IS_SHOW_TOP_BAR, true) ? View.VISIBLE : View.GONE);
        webViewBinding.webviewTopBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebViewActivity.this.finish();
            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = WebViewFragment.newInstance(getIntent().getStringExtra(Constants.URL), true);
        transaction.replace(R.id.webview_fragment, fragment).commit();
    }

    public void updateTitle(String title) {
        webViewBinding.webviewTopBar.setTitle(title);
    }
}