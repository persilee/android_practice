package net.lishaoy.nestedscroll.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class NestedRecyclerView extends RecyclerView {

    private static final String TAG = "NestedRecyclerView";

    public NestedRecyclerView(@NonNull Context context) {
        super(context);
    }

    public NestedRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NestedRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        Log.i(TAG, "setNestedScrollingEnabled: ");
        super.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        Log.i(TAG, "isNestedScrollingEnabled: ");
        return super.isNestedScrollingEnabled();
    }

    @Override
    public boolean startNestedScroll(int axes) {
        Log.i(TAG, "startNestedScroll: axes:" + axes);
        return super.startNestedScroll(axes);
    }

    @Override
    public boolean startNestedScroll(int axes, int type) {
        Log.i(TAG, "startNestedScroll: axes:" + axes + ", type: " + type);
        return super.startNestedScroll(axes, type);
    }

    @Override
    public void stopNestedScroll() {
        Log.i(TAG, "stopNestedScroll: ");
        super.stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        Log.i(TAG, "hasNestedScrollingParent: ");
        return super.hasNestedScrollingParent();
    }

    @Override
    public boolean hasNestedScrollingParent(int type) {
        Log.i(TAG, "hasNestedScrollingParent: type:" + type);
        return super.hasNestedScrollingParent(type);
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        Log.i(TAG, "dispatchNestedScroll: ");
        return super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        Log.i(TAG, "dispatchNestedPreScroll: ");
        return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        Log.i(TAG, "dispatchNestedFling: ");
        return super.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        Log.i(TAG, "dispatchNestedPreFling: ");
        return super.dispatchNestedPreFling(velocityX, velocityY);
    }
}
