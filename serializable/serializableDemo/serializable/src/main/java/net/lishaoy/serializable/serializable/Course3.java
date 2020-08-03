package net.lishaoy.serializable.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Course3 implements Serializable {
    private static final long serialVersionUID = 667279791530738499L;
    private String name;
    private float score;

    public Course3() {
        System.out.println("Course: empty");
    }

    public Course3(String name, float score) {
        System.out.println("Course: " + name + " " + score);
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException {
        System.out.println("readObject");
        inputStream.defaultReadObject();
        name = (String)inputStream.readObject();
        score = inputStream.readFloat();
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        System.out.println("writeObject");
        outputStream.defaultWriteObject();
        outputStream.writeObject(name);
        outputStream.writeFloat(score);
    }

    private Object readResolve() {
        System.out.println("readResolve");
        return new Course3(name, 85f);
    }

    private Object writeReplace(){
        System.out.println("writeReplace");
        return new Course3(name +"replace",score);
    }


    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String... args) throws Exception {
        Course3 course = new Course3("英语", 12f);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(course);
        byte[] bs = out.toByteArray();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bs));
        Course3 course1 = (Course3) ois.readObject();
        System.out.println("course1: " + course1);

    }
}
