package net.lishaoy.lazyloaddemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import net.lishaoy.lazyloaddemo.adapter.MyAdapter;
import net.lishaoy.lazyloaddemo.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView navigationView;
    private List<Fragment> fragments;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        BadgeDrawable badgeDrawable = navigationView.getOrCreateBadge(R.id.menu_item3);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(6);

        fragments = new ArrayList<>();
        fragments.add(MyFragment.newInstance("album"));
        fragments.add(MyFragment.newInstance("chart"));
        fragments.add(MyFragment.newInstance("favorite"));
        fragments.add(MyFragment.newInstance("beach"));
        adapter = new MyAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(pageChangeListener);

    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int item = R.id.menu_item1;
            switch (position) {
                case 0:
                    item = R.id.menu_item1;
                    break;
                case 1:
                    item = R.id.menu_item2;
                    break;
                case 2:
                    item = R.id.menu_item3;
                    break;
                case 3:
                    item = R.id.menu_item4;
                    break;
            }
            navigationView.setSelectedItemId(item);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.menu_item1:
                    viewPager.setCurrentItem(0, true);
                    return true;
                case R.id.menu_item2:
                    viewPager.setCurrentItem(1, true);
                    return true;
                case R.id.menu_item3:
                    viewPager.setCurrentItem(2, true);
                    return true;
                case R.id.menu_item4:
                    viewPager.setCurrentItem(3, true);
                    return true;
            }

            return false;
        }
    };
}