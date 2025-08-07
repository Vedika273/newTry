package org.example;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    String id;
    String firstName;
    String lastName;
    int age;
    char gender;
    int score;

    public Student(String id, String firstName, String lastName, int age, char gender, int score) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.score = score;
    }


    @Override
    public int compareTo(Student o) {
        return 1000 * this.age - o.age +
                100 * o.age - this.age;
    }
    public static class AgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.age, s2.age);
        }
    }
    public static class NameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return ;
        }
    }

}
