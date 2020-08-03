package net.lishaoy.serializable.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public enum Weekday {
    WEDNESDAY,THURSDAY;

    public void print() {
        System.out.println(WEDNESDAY + " " + WEDNESDAY.ordinal());
        System.out.println(THURSDAY + " " + THURSDAY.ordinal());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("weekDay.out");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(Weekday.THURSDAY);
        outputStream.close();
        Weekday.WEDNESDAY.print();
        System.out.println("===================");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Weekday weekday = (Weekday) inputStream.readObject();
        inputStream.close();
        weekday.print();
    }
}
