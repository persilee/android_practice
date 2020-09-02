package net.lishaoy.incidentdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

public class MyListView extends ListView {

    private static final String TAG = "My";
    private int lastX, lastY;

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true); // 禁止父布局拦截事件
                break;
            case MotionEvent.ACTION_MOVE:
                int x1 = x - lastX;
                int y1 = y - lastY;
                if (Math.abs(x1) > Math.abs(y1)) {
                    getParent().requestDisallowInterceptTouchEvent(false); // 允许父布局拦截事件
                }
                break;
        }

        lastX = x;
        lastY = y;

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.i(TAG, "onTouchEvent: ListView");
        return super.onTouchEvent(ev);
    }
}
