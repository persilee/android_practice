package net.lishaoy.incidentdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;
import java.util.Map;

public class ImageAdapter extends PagerAdapter {

    private Context context;
    private List<Map<String, Integer>> list;

    public ImageAdapter(Context context, List<Map<String, Integer>> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.item_image, null);
        ListView listView = view.findViewById(R.id.image_item);
        listView.setAdapter(new SimpleAdapter(container.getContext(), list, R.layout.item_base, new String[]{"key"}, new int[]{R.id.image}));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
