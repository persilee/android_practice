package net.lishaoy.incidentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private MyViewPager viewPager;
    private int[] images = new int[]{
            R.mipmap.image1,
            R.mipmap.image2,
            R.mipmap.image3,
            R.mipmap.image4,
            R.mipmap.image5,
            R.mipmap.image6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);

        List<Map<String, Integer>> list = new ArrayList<>();

        Map<String, Integer> map;

        for (int i = 0; i < 16; i++) {
            map = new HashMap<>();
            map.put("key", images[i % 6]);
            list.add(map);
        }

        ImageAdapter adapter = new ImageAdapter(this, list);
        viewPager.setAdapter(adapter);

    }
}