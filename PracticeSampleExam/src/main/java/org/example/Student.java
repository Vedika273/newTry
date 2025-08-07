package org.example;

import java.util.ArrayList;

public class Student extends User {
    private ArrayList<Course> courses;

    @Override
    public void report(String title, String content) {
         String.format ("Student, %d" , getId(),);
    }
}
