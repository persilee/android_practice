package net.lishaoy.nestedscroll.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.lishaoy.nestedscroll.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FixedScrollRecyclerView extends RecyclerView {
    public FixedScrollRecyclerView(@NonNull Context context) {
        super(context);
        init();
    }

    public FixedScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FixedScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        RecyclerAdapter adapter = new RecyclerAdapter(getData(), getContext());
        setAdapter(adapter);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return false;
    }

    private List<String> getData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            data.add("item " + i);
        }
        return data;
    }
}
