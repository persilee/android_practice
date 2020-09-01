package net.lishaoy.incidentdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MyViewPager extends ViewPager {

    private static final String TAG = "My";
    private int lastX;
    private int lastY;


    public MyViewPager(@NonNull Context context) {
        super(context);
        Log.i(TAG, "MyViewPager: 1");
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.i(TAG, "MyViewPager: 2");
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        Log.i(TAG, "x: " + x);
        Log.i(TAG, "y: " + y);

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN : {
                lastX = (int) ev.getX();
                lastY = (int) ev.getY();
                Log.i(TAG, "lastX: " + lastX);
                Log.i(TAG, "lastY: " + lastY);
                break;
            }
            case MotionEvent.ACTION_MOVE : {
                int x1 = x - lastX;
                int y1 = y - lastY;
                Log.i(TAG, "x1: " + x1);
                Log.i(TAG, "y1: " + y1);
                if (Math.abs(x1) > Math.abs(y1)) return true;
                break;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }
}
