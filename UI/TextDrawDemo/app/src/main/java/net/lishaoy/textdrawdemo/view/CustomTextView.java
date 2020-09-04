package net.lishaoy.textdrawdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView {

    private String text = "Text";
    private float percentage = 0.0f;

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
        invalidate();
    }

    public CustomTextView(@NonNull Context context) {
        super(context);
    }

    public CustomTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(166);
        paint.setColor(Color.BLACK);
        float width = paint.measureText(text);
        float x = getWidth() / 2 - width / 2;
        Paint.FontMetrics metrics = paint.getFontMetrics();
        float baseline = getHeight() / 2 - (metrics.descent + metrics.ascent) / 2;
        canvas.drawText(text, x, baseline, paint);

        canvas.save();
        paint.setColor(Color.MAGENTA);
        float endX = x + width * percentage;
        Rect rect = new Rect((int) x, 0, (int) endX, getHeight());
        canvas.clipRect(rect);
        canvas.drawText(text, x, baseline, paint);
        canvas.restore();

//        paint.setStrokeWidth(6);
//        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), paint);
//        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paint);

    }

}
