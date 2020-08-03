package net.lishaoy.serializable.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Person implements Serializable {

    private static final long serialVersionUID = 7911650650846382143L;
    private String name;
    private Integer age;
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    // 用 transient 关键字标记的成员变量不参与序列化
    private transient Date createTime;
    // 静态成员变量属于类而不属于对象，也不参与序列化
    private static SimpleDateFormat dateFormat = new SimpleDateFormat();

    public Student(String name, Integer age) {
        super(name);
        this.name = name;
        this.age = age;
        courses = new ArrayList<>();
        createTime = new Date();
        System.out.println("Student: name:" + name + " age:" + age + " createTime:" + createTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                ", createTime=" + createTime +
                '}';
    }
}
