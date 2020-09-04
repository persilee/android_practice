package net.lishaoy.textdrawdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ListView listView;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        String[] s = new String[]{
                "text draw",
                "viewPager text gradient",
                ""
        };

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, s);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            private Intent intent;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onClick: " + position);
                switch (position) {
                    case 0 :
                        intent = new Intent(MainActivity.this, TextDrawActivity.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}