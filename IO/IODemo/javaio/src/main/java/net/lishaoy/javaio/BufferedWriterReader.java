package net.lishaoy.javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterReader {

    private static String path = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(
                new FileWriter(
                        new File(path + "/javaio/src/outio/bufferedWriter.txt")
                )
        );

        writer.write("writer");

        BufferedReader reader = new BufferedReader(
                new FileReader(
                        new File(path + "/javaio/src/outio/bufferedReader.txt")
                )
        );

        char[] s = new char[1024];

        while (reader.read(s) != -1) {
            writer.write(s);
        }

        writer.flush();
        writer.close();
        reader.close();



    }

}
