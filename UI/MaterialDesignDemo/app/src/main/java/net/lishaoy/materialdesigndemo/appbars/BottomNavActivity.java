package net.lishaoy.materialdesigndemo.appbars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import net.lishaoy.materialdesigndemo.R;
import net.lishaoy.materialdesigndemo.adapter.ViewPagerAdapter;
import net.lishaoy.materialdesigndemo.fragment.NavFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomNavActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        getSupportActionBar().hide();

        viewPager2 = findViewById(R.id.view_pager);
        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        BadgeDrawable badgeDrawable = navigationView.getOrCreateBadge(R.id.favorite);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(6);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(NavFragment.newFragment("home"));
        fragments.add(NavFragment.newFragment("lic"));
        fragments.add(NavFragment.newFragment("favorite"));
        fragments.add(NavFragment.newFragment("my"));
        viewPager2.setAdapter(new ViewPagerAdapter(this, fragments));
        viewPager2.registerOnPageChangeCallback(onPageChangeCallback);
        View view = viewPager2.getChildAt(0);
        if (view instanceof RecyclerView) {
            view.setOverScrollMode(View.OVER_SCROLL_NEVER);
        }
    }

    ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            navigationView.getMenu().getItem(position).setChecked(true);
        }
    };

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    viewPager2.setCurrentItem(0, true);
                    return true;
                case R.id.lic:
                    viewPager2.setCurrentItem(1, true);
                    return true;
                case R.id.favorite:
                    viewPager2.setCurrentItem(2, true);
                    return true;
                case R.id.my:
                    viewPager2.setCurrentItem(3, true);
                    return true;
            }
            return false;
        }
    };
}