package net.lishaoy.textdrawdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import net.lishaoy.textdrawdemo.adapter.ViewPagerAdapter;
import net.lishaoy.textdrawdemo.fragment.ViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        tabLayout = findViewById(R.id.tab);
        viewPager2 = findViewById(R.id.view_pager);
        pagerAdapter = new ViewPagerAdapter(this, getFragments());
        viewPager2.setAdapter(pagerAdapter);
        final String[] strings = new String[]{"tab1", "tab2", "tab3"};
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(strings[position]);
            }
        }).attach();
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ViewPagerFragment());
        fragments.add(new ViewPagerFragment());
        fragments.add(new ViewPagerFragment());

        return fragments;
    }
}