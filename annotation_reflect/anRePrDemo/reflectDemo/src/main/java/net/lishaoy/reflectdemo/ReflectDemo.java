package net.lishaoy.reflectdemo;

import net.lishaoy.reflectdemo.entity.Cook;

public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Cook cook = new Cook();
        cook.cookService("🍅");

        Class cookClass = Cook.class;
        Class cookClass1 = cook.getClass();
        Class cookClass2 = Class.forName("net.lishaoy.reflectdemo.entity.Cook");

        Cook cook1 = (Cook) cookClass.newInstance();
    }

}