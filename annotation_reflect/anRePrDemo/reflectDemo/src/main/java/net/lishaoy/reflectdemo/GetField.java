package net.lishaoy.reflectdemo;

import net.lishaoy.reflectdemo.entity.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class GetField {

    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchFieldException,
            IllegalAccessException,
            InstantiationException {

        Class<?> aClass = Class.forName("net.lishaoy.reflectdemo.entity.Person");

        // 获取所有字段(不包含父类字段)
        Field[] fields = aClass.getDeclaredFields();
        for (Field field: fields) {
            System.out.println("获取所有字段: " + field.getName());
        }

        System.out.println("================");

        // 获取指定字段
        Field name = aClass.getDeclaredField("name");
        System.out.println("获取指定字段: " + name.getName());

        // 设置指定字段的值
        Object instance = aClass.newInstance();
        name.set(instance, "per");

        // 获取指定字段的值
        Object o = name.get(instance);
        System.out.println("获取指定字段的值: " + o);

        // 设置和获取私有字段的值
        Field age = aClass.getDeclaredField("age");
        age.setAccessible(true); // 需要调用此方法且设置为 true
        age.set(instance, 66);
        System.out.println("获取私有字段的值: " + age.get(instance));

    }

}
