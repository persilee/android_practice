package net.lishaoy.proxydemo.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

public class ProxyUtil {

    public static void generateClassFile(Class aClass, String proxyName) {

        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                proxyName,
                new Class[]{aClass}
        );
        String path = aClass.getResource(".").getPath();
        System.out.println(path);
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(path + proxyName + ".class");
            outputStream.write(proxyClassFile);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
