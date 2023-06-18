package com.baonguyen.praticecollection;

import java.util.Date;

public class Student {
    private String name;
    private String className;
    private Date joinTime;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, String className, Date joinTime, int age) {
        this.name = name;
        this.className = className;
        this.joinTime = joinTime;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", joinTime=" + joinTime +
                ", age=" + age +
                '}';
    }
}
