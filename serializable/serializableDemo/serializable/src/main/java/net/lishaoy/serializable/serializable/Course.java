package net.lishaoy.serializable.serializable;

import java.io.Serializable;

public class Course implements Serializable {

    private static final long serialVersionUID = 7980496416494451794L;
    private String name;
    private float score;

    public Course(String name, float score) {
        this.name = name;
        this.score = score;
        System.out.println("Course: " + "name:" + name + " score:" + score);
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
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
