package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Student extends User implements ManageCourse{
    ArrayList<Course> courses = new ArrayList<>();

    public Student() {
        super();
        this.courses = new ArrayList<>();
    }

    public Student(int id, String name, String gender, int age, ArrayList<Course> courses) {
        super(id, name, gender, age);
        this.courses = courses;
    }

    public Student(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void report(String title, String content) {
        String infos = String.format("Student, ID: %d, Name: %s, \n, Title: %s, Context: %s", getId(), getName(), title, content);
        System.out.println(infos);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "courses=" + courses +
                '}' + super.toString();
    }

    @Override
    public boolean register(Course course) {
        if ( )
    }

    @Override
    public boolean drop(Course course) {
        return false;
    }
}
