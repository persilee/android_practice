package net.lishaoy.reflectdemo.entity;

public class Person {

    public String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        super();
    }

    public String getName() {
        System.out.println("get name: " + name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("set name: " + this.name);
    }

    public int getAge() {
        System.out.println("get age: " + age);
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("set age: " + this.age);
    }

    private void privateMethod(){
        System.out.println("the private method!");
    }
}
