package net.lishaoy.serializabledemo.entity;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;
    private List<Course> courses;

    public Student() {
        courses = new ArrayList<>();
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        courses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void addAllCourses(List<Course> courses){
        this.courses.addAll(courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                '}';
    }
}
