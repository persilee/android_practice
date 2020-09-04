package net.lishaoy.textdrawdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class TextDrawActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_draw);

        textView = findViewById(R.id.text_view);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startShadow();
            }
        }, 1600);
    }

    @SuppressLint("ObjectAnimatorBinding")
    private void startShadow() {
        ObjectAnimator.ofFloat(textView, "percentage", 0, 1).setDuration(6000).start();
    }


}