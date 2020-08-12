package net.lishaoy.javaio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutPutWriter {

    private static String path = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {

        FileOutputStream outputStream = new FileOutputStream(
                new File(path + "/javaio/src/outio/OutPutStreamWriter.txt"), true // 设置内容可以追加
        );

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(outputStream)
        );

        writer.write("this is writer");
        writer.newLine();
        writer.flush();

        BufferedWriter writerGBK = new BufferedWriter(
                new OutputStreamWriter(outputStream, "GBK")
        );

        writerGBK.write("this is writerGBK");
        writerGBK.newLine();
        writerGBK.flush();

        BufferedWriter writerUTF8 = new BufferedWriter(
                new OutputStreamWriter(outputStream, "UTF-8")
        );

        writerGBK.write("this is writerUTF8");
        writerGBK.newLine();
        writerGBK.flush();

        writer.close();
        writerGBK.close();
        writerUTF8.close();
    }

}
