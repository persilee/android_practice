package net.lishaoy.constomviewdemo;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;

public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}