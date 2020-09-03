package net.lishaoy.nestedscroll.view.custom_nestedscrollview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import net.lishaoy.nestedscroll.R;
import net.lishaoy.nestedscroll.adapter.ViewPagerAdapter;
import net.lishaoy.nestedscroll.fragment.RecyclerViewFragment;

import java.util.ArrayList;
import java.util.List;

public class CustomNestedScrollActivity extends AppCompatActivity {

    private SwipeRefreshLayout refreshLayout;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_nested_scroll);

        pagerAdapter = new ViewPagerAdapter(this, getFragments());
        viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setAdapter(pagerAdapter);
        final String[] strings = new String[]{"A", "B", "C"};
        tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(strings[position]);
            }
        }).attach();

        refreshLayout = findViewById(R.id.swipe_refresh);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);
            }
        });

    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new RecyclerViewFragment());
        fragments.add(new RecyclerViewFragment());

        return fragments;
    }
}