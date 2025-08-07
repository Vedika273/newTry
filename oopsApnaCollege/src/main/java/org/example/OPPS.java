package org.example;

class Pen {

    //blueprint of pen

   String color;
   String type;  //ballPoint, gel


    //functions
    public void write() {
        System.out.println("writing something");


    }

    public void printColor() {
        System.out.println(this.color);
    }
}

public class OPPS {
    //make an object  ///have to make it in the main method
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Aman";
        s1.age = 24;

        s1.printInfo(); 

    }

}

class Student {
    String name;
    int age;

    public void printInfo() {
        System.out.println(this.name);
        System.out.println(this.age);
    }
}