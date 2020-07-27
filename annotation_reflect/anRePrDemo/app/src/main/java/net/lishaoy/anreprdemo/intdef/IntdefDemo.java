package net.lishaoy.anreprdemo.intdef;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

class IntdefDemo {

    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;

    private static int weekDay;

    @IntDef({SATURDAY, SUNDAY})
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface WeekDay {

    }

    public static void setWeekDay(@WeekDay int weekDay) {
        IntdefDemo.weekDay = weekDay;
    }

    public static void main(String[] args) {
        setWeekDay(SATURDAY);
    }
}
