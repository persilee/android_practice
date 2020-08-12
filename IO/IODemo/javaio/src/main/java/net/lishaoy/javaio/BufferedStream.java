package net.lishaoy.javaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStream {

    private static final byte[] byteArray = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };
    private static String path = System.getProperty("user.dir");
    private static File file = new File(path + "/javaio/src/outio/bufferedOutPutStream.txt");

    public static void main(String[] args) throws IOException {

//        bufferedOutStreamTest();
        bufferedInputStreamTest();

    }

    private static void bufferedOutStreamTest() throws IOException {

        BufferedOutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(file)
        );

        outputStream.write(byteArray[6]);
        outputStream.write(byteArray, 1, byteArray.length - 1);
        outputStream.flush();
        outputStream.close();

    }

    private static void bufferedInputStreamTest() throws IOException {

        BufferedInputStream inputStream = new BufferedInputStream(
                new FileInputStream(file)
        );

        for (int i = 0; i < inputStream.available(); i++) {
            System.out.println(inputStream.read());
        }

    }

}
