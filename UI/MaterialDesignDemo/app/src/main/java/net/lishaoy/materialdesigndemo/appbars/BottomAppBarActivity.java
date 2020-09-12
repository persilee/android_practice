package net.lishaoy.materialdesigndemo.appbars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import net.lishaoy.materialdesigndemo.R;

public class BottomAppBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);

        getSupportActionBar().hide();
    }
}