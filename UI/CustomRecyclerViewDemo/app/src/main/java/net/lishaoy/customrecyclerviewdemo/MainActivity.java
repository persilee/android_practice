package net.lishaoy.customrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import net.lishaoy.customrecyclerviewdemo.bean.DataBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<DataBean> getData() {

        List<DataBean> beans = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 12; j++) {
                if (i % 2 == 0){
                    beans.add(new DataBean("item" + j, "item title" + i));
                }else {
                    beans.add(new DataBean("text" + j, "text title" + i));
                }
            }
        }

        return beans;
    }

}