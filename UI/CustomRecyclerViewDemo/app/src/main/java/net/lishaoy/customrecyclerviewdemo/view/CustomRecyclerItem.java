package net.lishaoy.customrecyclerviewdemo.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.lishaoy.customrecyclerviewdemo.adapter.RecyclerAdapter;
import net.lishaoy.customrecyclerviewdemo.util.Utils;

public class CustomRecyclerItem extends RecyclerView.ItemDecoration {

    private static final String TAG = "CustomRecyclerItem";

    private int titleHeight;
    private Paint titlePaint;
    private Paint dividerPaint;
    private Paint textPaint;
    private Rect textRect;

    public CustomRecyclerItem() {
        titleHeight = (int) Utils.dp2px(100);
        titlePaint = new Paint();
        titlePaint.setColor(Color.LTGRAY);
        dividerPaint = new Paint();
        dividerPaint.setColor(Color.LTGRAY);
        textPaint = new Paint();
        textPaint.setTextSize(96);
        textPaint.setColor(Color.WHITE);
        textRect = new Rect();
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (parent.getAdapter() instanceof RecyclerAdapter) {
            RecyclerAdapter adapter = (RecyclerAdapter) parent.getAdapter();
            int count = parent.getChildCount();// 当前屏幕的item个数
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            for (int i = 0; i < count; i++) {
                View view = parent.getChildAt(i);
                Log.i(TAG, "onDraw: getTop:" + view.getTop());
                int position = parent.getChildLayoutPosition(view);
                boolean isTitle = adapter.isTitle(position);
                if (isTitle && view.getTop() - titleHeight - parent.getPaddingTop() >= 0) {
                    c.drawRect(left, view.getTop() - titleHeight, right, view.getTop(), titlePaint);
                    String title = adapter.getGroup(position);
                    textPaint.getTextBounds(title, 0, title.length(), textRect);
                    c.drawText(title, left + 66, view.getTop() - titleHeight / 2 + textRect.height() / 2, textPaint);
                } else {
                    c.drawRect(left, view.getTop() - 2, right, view.getTop(), dividerPaint);
                }
            }
        }
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        if (parent.getAdapter() instanceof RecyclerAdapter) {
            RecyclerAdapter adapter = (RecyclerAdapter) parent.getAdapter();
            int position = ((LinearLayoutManager) parent.getLayoutManager()).findFirstVisibleItemPosition();
            View view = parent.findViewHolderForAdapterPosition(position).itemView;
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            int top = parent.getPaddingTop();
            boolean isTitle = adapter.isTitle(position + 1);
            if (isTitle) {
                int bottom = Math.min(titleHeight, view.getBottom() - parent.getPaddingTop());
                c.drawRect(left, top, right, top + bottom, titlePaint);
                String title = adapter.getGroup(position);
                titlePaint.getTextBounds(title, 0, title.length(), textRect);
                c.drawText(title, left + 66, top + titleHeight / 2 + textRect.height() / 2 + bottom, titlePaint);
            } else {
                c.drawRect(left, top, right, top + titleHeight, titlePaint);
                String title = adapter.getGroup(position);
                titlePaint.getTextBounds(title, 0, title.length(), textRect);
                c.drawText(title, left + 66, top + titleHeight / 2 + textRect.height() / 2, textPaint);
            }
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getAdapter() instanceof RecyclerAdapter) {
            RecyclerAdapter adapter = (RecyclerAdapter) parent.getAdapter();
            int position = parent.getChildLayoutPosition(view);
            boolean isTitle = adapter.isTitle(position);
            if (isTitle) {
                outRect.set(0, titleHeight, 0, 0);
            } else {
                outRect.set(0, 2, 0, 0);
            }
        }
    }
}
