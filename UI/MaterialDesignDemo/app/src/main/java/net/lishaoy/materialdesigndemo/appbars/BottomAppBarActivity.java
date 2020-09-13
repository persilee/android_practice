package net.lishaoy.materialdesigndemo.appbars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

import net.lishaoy.materialdesigndemo.R;
import net.lishaoy.materialdesigndemo.adapter.BottomAppBarRecyclerAdapter;

public class BottomAppBarActivity extends AppCompatActivity {

    private BottomAppBar bottomAppBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);

        getSupportActionBar().hide();

        bottomAppBar = findViewById(R.id.bottomAppBar);
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BottomAppBarActivity.this, "bottom bar menu", Toast.LENGTH_SHORT).show();
            }
        });

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.search:
                        Toast.makeText(BottomAppBarActivity.this, "search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.more:
                        Toast.makeText(BottomAppBarActivity.this, "more", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        recyclerView = findViewById(R.id.bottom_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BottomAppBarRecyclerAdapter(this));
    }
}