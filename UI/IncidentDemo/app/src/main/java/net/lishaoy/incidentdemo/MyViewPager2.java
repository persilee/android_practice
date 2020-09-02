package net.lishaoy.incidentdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MyViewPager2 extends ViewPager {

    private static final String TAG = "My";
    private int lastX;
    private int lastY;


    public MyViewPager2(@NonNull Context context) {
        super(context);
        Log.i(TAG, "MyViewPager: 1");
    }

    public MyViewPager2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.i(TAG, "MyViewPager: 2");
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_DOWN) {
            super.onInterceptTouchEvent(ev);
            return false;
        }
        return true;
    }
}
