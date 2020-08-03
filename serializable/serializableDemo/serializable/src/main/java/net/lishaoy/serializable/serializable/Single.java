package net.lishaoy.serializable.serializable;

import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Single {

    private static SingleClass reflectSingle(SingleClass singleClass) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {

        Class<SingleClass> aClass1 = (Class<SingleClass>) Class.forName("net.lishaoy.serializable.serializable.SingleClass");
        Constructor<SingleClass> constructor = aClass1.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        SingleClass aClass2 = aClass1.newInstance();
        SingleClass aClass3 = aClass1.newInstance();
        System.out.println(singleClass.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SingleClass singleClass = SingleClass.getInstance();
        // 序列化
        SerializableUtil.serializable(singleClass);
        // 反序列化
        SingleClass singleClass1 = SerializableUtil.reverseSerializable();
        System.out.println("序列化之前：" + singleClass.hashCode());
        System.out.println("序列化之后："+ singleClass1.hashCode());

        reflectSingle(singleClass);
    }

}
