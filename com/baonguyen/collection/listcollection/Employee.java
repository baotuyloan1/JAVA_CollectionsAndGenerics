package com.baonguyen.collection.listcollection;

public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private int salary;
    private String jobTitle;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, String jobTitle , int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.jobTitle = jobTitle;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

//    trả về số âm, nghĩa là đôi tượng hiện tại đứng trước đối tượng so sánh
//    nếu giá trị trả về số 0, có nghĩa là đối tượng hiên tại và đói tượng so sánh bwangf nhau
//    trả về giá trị dương, có nghĩa là đối tượng hiện tại đứng sau đối tượng so sánh
    public int compareTo(Employee employee) {
//        lớn về nhỏ
        return this.salary - employee.salary;
    }

    @Override
    public String toString() {
        return "EmployeeComparable{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
