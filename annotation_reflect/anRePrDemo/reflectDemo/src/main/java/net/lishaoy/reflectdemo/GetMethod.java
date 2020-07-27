package net.lishaoy.reflectdemo;

import net.lishaoy.reflectdemo.entity.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class GetMethod {

    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InstantiationException,
            InvocationTargetException {

        Class<?> aClass = Class.forName("net.lishaoy.reflectdemo.entity.Person");

        //获取所有的public方法(包含从父类继承的方法)
        Method[] methods = aClass.getMethods();
        for (Method method: methods) {
            System.out.println("获取所有public方法： " + method.getName() + "()");
        }

        System.out.println("===========================");

        //获取所有方法(不包含父类方法)
        methods = aClass.getDeclaredMethods();
        for (Method method: methods) {
            System.out.println("获取所有方法: " + method.getName() + "()");
        }

        System.out.println("===========================");

        //获取指定的方法
        Method method = aClass.getDeclaredMethod("setAge", int.class);
        System.out.println("获取指定的方法:" + method);

        //调用方法
        Object instance = aClass.newInstance();
        method.invoke(instance, 66);

        //调用私有方法
        method = aClass.getDeclaredMethod("privateMethod");
        method.setAccessible(true); // 需要调用此方法且设置为 true
        method.invoke(instance);

    }

}
