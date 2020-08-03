package net.lishaoy.serializable.externalizable;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Course implements Externalizable {

    private static final long serialVersionUID = -342346458732794596L;
    private String name;
    private float score;

    public Course(){}

    public Course(String name, float score) {
        this.name = name;
        this.score = score;
        System.out.println("Course: " + "name " + name + " score " + score);
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

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        System.out.println("writeExternal ...");
        objectOutput.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        System.out.println("readExternal ...");
        name = (String) objectInput.readObject();
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course = new Course("数学",66);
        // 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(course);
        course.setName("英语");
        outputStream.reset();
        outputStream.writeObject(course);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        outputStream.close();

        // 反序列化
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Course course1 = (Course) inputStream.readObject();
        Course course2 = (Course) inputStream.readObject();
        System.out.println(course1);
        System.out.println(course2);
    }
}
