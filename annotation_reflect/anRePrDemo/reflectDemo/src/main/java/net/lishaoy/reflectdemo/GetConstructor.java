package net.lishaoy.reflectdemo;

import net.lishaoy.reflectdemo.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class GetConstructor {

    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        String className = "net.lishaoy.reflectdemo.entity.Person";
        Class<Person> personClass = (Class<Person>) Class.forName(className);

        //获取全部的constructor对象
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor: constructors) {
            System.out.println("获取全部的constructor对象: " + constructor);
        }

        //获取某一个constructor对象
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        System.out.println("获取某一个constructor对象: " + constructor);

        //调用构造器的 newInstance() 方法创建对象
        Person person = constructor.newInstance("lsy", 66);
        System.out.println(person.getName() + ", " + person.getAge() );
    }

}
