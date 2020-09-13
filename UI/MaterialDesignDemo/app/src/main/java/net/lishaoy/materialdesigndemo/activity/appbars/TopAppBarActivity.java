package net.lishaoy.materialdesigndemo.activity.appbars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import net.lishaoy.materialdesigndemo.R;
import net.lishaoy.materialdesigndemo.adapter.AppBarRecyclerAdapter;

public class TopAppBarActivity extends AppCompatActivity {

    private MaterialToolbar topAppBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_app_bar);
        getSupportActionBar().hide();

        topAppBar = findViewById(R.id.top_app_bar);
        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopAppBarActivity.this, "top bar menu", Toast.LENGTH_SHORT).show();
            }
        });

        topAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.favorite:
                        Toast.makeText(TopAppBarActivity.this, "favorite", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        Toast.makeText(TopAppBarActivity.this, "search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.more:
                        Toast.makeText(TopAppBarActivity.this, "more", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        recyclerView = findViewById(R.id.top_bar_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AppBarRecyclerAdapter(this));
    }
}