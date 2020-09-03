package net.lishaoy.nestedscroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import net.lishaoy.nestedscroll.adapter.ListViewAdapter;
import net.lishaoy.nestedscroll.bean.Item;
import net.lishaoy.nestedscroll.view.custom_nestedscrollview.CustomNestedScrollActivity;
import net.lishaoy.nestedscroll.view.custom_nestedscrollview.CustomNestedScrollView;
import net.lishaoy.nestedscroll.view.nestedscrollview.NestedScrollActivity;
import net.lishaoy.nestedscroll.view.scrollview.ScrollViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        listView = findViewById(R.id.list_navigation);
        icon = findViewById(R.id.icon);

        List<Item> data = new ArrayList<>();
        Item item = new Item(R.drawable.ic_list, "ScrollView", ScrollViewActivity.class);
        data.add(item);
        item = new Item(R.drawable.ic_list, "NestedScrollView", NestedScrollActivity.class);
        data.add(item);
        item = new Item(R.drawable.ic_list, "CustomNestedScrollView", CustomNestedScrollActivity.class);
        data.add(item);

        ListViewAdapter adapter = new ListViewAdapter(data, this);

        listView.setAdapter(adapter);

    }
}
