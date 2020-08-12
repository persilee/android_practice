package net.lishaoy.javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InPutReader {

    private static String path = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(
                new File(path + "/javaio/src/outio/OutPutStreamWriter.txt")
        );

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        inputStream
                )
        );

        String s;
        while ((s = reader.readLine()) != null) {

            System.out.println(s);

        }

        reader.close();

    }

}
