package net.lishaoy.libwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import net.lishaoy.base.autoservice.AutoServiceLoader;
import net.lishaoy.common.autoservice.IWebViewService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_to_webview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IWebViewService webViewService = AutoServiceLoader.load(IWebViewService.class);
                if (webViewService != null) {
                    webViewService.openWebView(MainActivity.this, "https://www.baidu.com", "百度", true);
                }
            }
        });
    }
}