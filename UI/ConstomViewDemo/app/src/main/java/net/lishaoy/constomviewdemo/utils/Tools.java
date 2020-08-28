package net.lishaoy.constomviewdemo.utils;

import android.content.res.Resources;
import android.util.TypedValue;

public class Tools {
    public static int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }
}
