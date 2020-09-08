package net.lishaoy.customrecyclerviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import net.lishaoy.customrecyclerviewdemo.util.Utils;

public class CustomCardLayoutManager extends RecyclerView.LayoutManager {
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {

        detachAndScrapAttachedViews(recycler); // 复用 ViewHolder

        int bottomPosition;
        int itemCount = getItemCount();
        if (itemCount < 4) {
            bottomPosition = 0;
        } else {
            bottomPosition = itemCount - 4;
        }

        for (int i = bottomPosition; i < itemCount; i++) {
            View view = recycler.getViewForPosition(i);
            addView(view);

            measureChildWithMargins(view, 0, 0);
            int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
            int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);

            layoutDecoratedWithMargins(
                    view,
                    widthSpace / 2,
                    heightSpace / 2,
                    widthSpace /2 + getDecoratedMeasuredWidth(view),
                    heightSpace / 2 + getDecoratedMeasuredHeight(view)
            );

            int level = itemCount - i - 1;
            if (level > 0) {
                if (level < 4){
                    view.setTranslationY(Utils.dp2px(16) * level);
                    view.setScaleX(1 - 0.06f * level);
                    view.setScaleY(1 - 0.06f * level);
                } else {
                    view.setTranslationY(Utils.dp2px(16) * (level - 1));
                    view.setScaleX(1 - 0.06f * (level - 1));
                    view.setScaleY(1 - 0.06f * (level - 1));
                }
            }

        }

    }
}
