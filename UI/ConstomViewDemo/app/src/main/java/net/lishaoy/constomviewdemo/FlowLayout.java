package net.lishaoy.constomviewdemo;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;

import net.lishaoy.constomviewdemo.utils.Tools;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {

    private static final String TAG = "FlowLayout";
    private int horizontalSpacing = Tools.dp2px(16); // 水平间距
    private int verticalSpacing = Tools.dp2px(12); // 竖直间距
    private List<List<View>> lines = new ArrayList<>(); // 所有行
    private List<Integer> lineHeights = new ArrayList<>(); // 行高

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void clearParams() {
        lines.clear();
        lineHeights.clear();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        clearParams();

        int childCount = getChildCount(); // 个数
        int paddingLeft = getPaddingLeft(); // padding
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        int selfWidth = MeasureSpec.getSize(widthMeasureSpec);  // 父view给的宽度
        int selfHeight = MeasureSpec.getSize(heightMeasureSpec); // 父view给的高度

        List<View> lineViews = new ArrayList<>(); // 每一行的view
        int lineWidth = 0;
        int lineHeight = 0;

        int parentWidth = 0;
        int parentHeight = 0;

        for (int i = 0; i < childCount; i++) {

            View child = getChildAt(i);
            LayoutParams layoutParams = child.getLayoutParams();
            if (child.getVisibility() != View.GONE) {

                int childMeasureSpecWidth = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, layoutParams.width);
                int childMeasureSpecHeight = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, layoutParams.height);
                child.measure(childMeasureSpecWidth, childMeasureSpecHeight);

                int measuredWidth = child.getMeasuredWidth();
                int measuredHeight = child.getMeasuredHeight();

                if (measuredWidth + lineWidth + horizontalSpacing > selfWidth) {
                    lines.add(lineViews);
                    lineHeights.add(lineHeight);
                    parentWidth = Math.max(parentWidth, lineWidth + horizontalSpacing);
                    parentHeight = parentHeight + lineHeight + verticalSpacing;

                    lineViews = new ArrayList<>();
                    lineWidth = 0;
                    lineHeight = 0;
                }

                lineViews.add(child);
                lineWidth = lineWidth + measuredWidth + horizontalSpacing;
                lineHeight = Math.max(lineHeight, measuredHeight);

                if(i == childCount - 1) {
                    lines.add(lineViews);
                    lineHeights.add(lineHeight);
                    parentWidth = Math.max(parentWidth, lineWidth + horizontalSpacing);
                    parentHeight = parentHeight + lineHeight + verticalSpacing;
                }
            }

        }

        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        int width = (modeWidth == MeasureSpec.EXACTLY) ? selfWidth : parentWidth;
        int height = (modeHeight == MeasureSpec.EXACTLY) ? selfHeight : parentHeight;

        setMeasuredDimension(width, height);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int lineCount = lines.size();
        int vL = getPaddingLeft();
        int vT = getPaddingTop();

        for (int i = 0; i < lineCount; i++) {
            List<View> lineViews = lines.get(i);
            int lineHeight = lineHeights.get(i);
            for (int j = 0; j < lineViews.size(); j++) {
                View view = lineViews.get(j);
                int left = vL;
                int top = vT;
                int right = left + view.getMeasuredWidth();
                int bottom = top + view.getMeasuredHeight();
                view.layout(left, top, right, bottom);
                vL = right + horizontalSpacing;
            }
            vL = getPaddingLeft();
            vT = vT + lineHeight + verticalSpacing;
        }

    }
}