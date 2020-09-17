package net.lishaoy.libwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import net.lishaoy.webview.WebViewActivity;
import net.lishaoy.webview.utils.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_to_webview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra(Constants.URL, "https://www.baidu.com");
                intent.putExtra(Constants.TITLE, "百度");
                intent.putExtra(Constants.IS_SHOW_TOP_BAR, true);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}