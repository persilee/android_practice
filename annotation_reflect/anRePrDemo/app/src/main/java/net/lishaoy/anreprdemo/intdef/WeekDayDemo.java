package net.lishaoy.anreprdemo.intdef;

class WeekDayDemo {

    private static WeekDay weekDay;

    enum WeekDay {
        SATURDAY,SUNDAY
    }

    public static WeekDay getWeekDay() {
        return weekDay;
    }

    public static void setWeekDay(WeekDay weekDay) {
        WeekDayDemo.weekDay = weekDay;
    }

    public static void main(String[] args) {
        setWeekDay(WeekDay.SATURDAY);
        System.out.println(getWeekDay());
    }
}
