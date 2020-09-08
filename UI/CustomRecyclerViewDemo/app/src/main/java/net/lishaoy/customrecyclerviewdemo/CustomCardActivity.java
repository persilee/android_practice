package net.lishaoy.customrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import net.lishaoy.customrecyclerviewdemo.adapter.CardAdapter;
import net.lishaoy.customrecyclerviewdemo.adapter.GeneralAdapter;
import net.lishaoy.customrecyclerviewdemo.adapter.RecyclerAdapter;
import net.lishaoy.customrecyclerviewdemo.adapter.ViewHolder;
import net.lishaoy.customrecyclerviewdemo.bean.CardBean;

import java.util.List;

public class CustomCardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<CardBean> cardBeans;
    private GeneralAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_card);

        recyclerView = findViewById(R.id.custom_card);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cardBeans = CardBean.getCardData();

        adapter = new GeneralAdapter<CardBean>(this, cardBeans, R.layout.card_item) {
            @Override
            public void convert(ViewHolder viewHolder, CardBean cardBean) {
                viewHolder.setText(R.id.title, cardBean.getName());
                viewHolder.setText(R.id.number, cardBean.getPosition() + "/" + cardBeans.size());
                viewHolder.setImageResource(R.id.image, cardBean.getResource());
            }
        };

        recyclerView.setAdapter(adapter);

    }
}