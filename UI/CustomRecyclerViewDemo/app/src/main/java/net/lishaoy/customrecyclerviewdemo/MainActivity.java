package net.lishaoy.customrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import net.lishaoy.customrecyclerviewdemo.adapter.RecyclerAdapter;
import net.lishaoy.customrecyclerviewdemo.bean.DataBean;
import net.lishaoy.customrecyclerviewdemo.view.CustomRecyclerItem;

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
        RecyclerAdapter adapter = new RecyclerAdapter(this, getData());
        recyclerView.addItemDecoration(new CustomRecyclerItem());
        recyclerView.setAdapter(adapter);
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