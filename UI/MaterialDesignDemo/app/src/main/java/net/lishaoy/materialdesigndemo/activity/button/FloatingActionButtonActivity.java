package net.lishaoy.materialdesigndemo.activity.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import net.lishaoy.materialdesigndemo.R;

public class FloatingActionButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);
        getSupportActionBar().hide();
    }
}