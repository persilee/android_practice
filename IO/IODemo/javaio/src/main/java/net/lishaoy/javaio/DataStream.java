package net.lishaoy.javaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

    public static String path = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {

        dataOutPutStreamTest();
        dataInputStreamTest();

    }

    private static void dataOutPutStreamTest() throws IOException {
        DataOutputStream outputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(
                                new File(path + "/javaio/src/outio/dataOutStream.txt")
                        )
                ));

        outputStream.writeBoolean(false);
        outputStream.writeByte(0x66);
        outputStream.writeShort(0x16);
        outputStream.writeInt(66);
        outputStream.writeDouble(6.6);
        outputStream.writeChars("string");
        outputStream.writeUTF("utfString");
        outputStream.close();
    }

    private static void dataInputStreamTest() throws IOException {
        DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(
                                new File(path + "/javaio/src/outio/dataOutStream.txt")
                        )
                ));
        System.out.println(inputStream.readBoolean());
        System.out.println(inputStream.readByte());
        System.out.println(inputStream.readShort());
        System.out.println(inputStream.readInt());
        System.out.println(inputStream.readDouble());
        for (int i = 0; i < 6; i++) {
            System.out.print(inputStream.readChar());
        }
        System.out.println();
        System.out.println(inputStream.readUTF());
        inputStream.close();
    }

}