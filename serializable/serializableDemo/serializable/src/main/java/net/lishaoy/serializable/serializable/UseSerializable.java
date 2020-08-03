package net.lishaoy.serializable.serializable;

public class UseSerializable {

    public static void main(String[] args) {
        Student student = new Student("lsy", 66);
        student.addCourse(new Course("英语",66));
        // 序列化
        SerializableUtil.serializable(student);
        // 反序列化
        SerializableUtil.reverseSerializable();
    }

}