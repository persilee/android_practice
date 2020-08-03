package net.lishaoy.serializable.serializable;

import net.lishaoy.serializable.externalizable.Course;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ReadWriteObjectCourse implements Serializable {

    private static final long serialVersionUID = -6828110073372979297L;
    private String name;
    private float score;

    public ReadWriteObjectCourse(){}

    public ReadWriteObjectCourse(String name, float score) {
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
    // 重写 writeObject() 方法，只序列化 name 字段
    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        System.out.println("writeObject ...");
        outputStream.writeObject(name);
    }
    // 重写 readObject() 方法，只反序列化 name 字段
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        System.out.println("readObject ...");
        name = (String) inputStream.readObject();
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ReadWriteObjectCourse course = new ReadWriteObjectCourse("数学",66);
        // 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(course);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        outputStream.close();

        // 反序列化
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        ReadWriteObjectCourse course1 = (ReadWriteObjectCourse) inputStream.readObject();
        System.out.println(course1);
    }
}
