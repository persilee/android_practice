package net.lishaoy.materialdesigndemo.activity.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import net.lishaoy.materialdesigndemo.R;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        getSupportActionBar().hide();
    }
}