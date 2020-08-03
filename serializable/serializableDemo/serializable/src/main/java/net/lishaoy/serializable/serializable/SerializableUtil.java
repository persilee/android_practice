package net.lishaoy.serializable.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableUtil {

    private static String path = System.getProperty("user.dir") + "/serializable/src/main/java/net/lishaoy/serializable/serializable/out/student.out";

    public static synchronized boolean serializable(Object o) {
        if (o == null) {
            return false;
        }
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(path));
            outputStream.writeObject(o);
            outputStream.close();
            System.out.println("序列化成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    public static synchronized <T> T reverseSerializable() {
        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(new FileInputStream(path));
            Object object = inputStream.readObject();
            System.out.println("反序列化成功！\n"  + object);
            return (T) object;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
