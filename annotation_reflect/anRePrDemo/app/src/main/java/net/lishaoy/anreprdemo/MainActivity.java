package net.lishaoy.anreprdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import net.lishaoy.anreprdemo.inject.BindView;
import net.lishaoy.anreprdemo.inject.InjectView;

@Persilee(id = 666, value = "lsy")
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_view)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // 初始化 InjectView，完成自动 findViewById 功能
        InjectView.init(this);
        // 测试 R.id.text_view 是否自动赋值给 textView
        textView.setText("通过 @BindView 注解自动完成 findViewById");
    }
}

