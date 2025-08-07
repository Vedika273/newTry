package org.example;

import employeemanagagementsystem.Employee;
import employeemanagagementsystem.FullTimeEmployee;
import employeemanagagementsystem.PartTimeEmployee;
import flexiblestudentcomparator.Student;
import librarycatalogsystem.Book;
import librarycatalogsystem.Ebook;
import librarycatalogsystem.PrintedBook;

import java.util.ArrayList;
import java.util.Collections;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //sorting students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(102, "Alice", 85.0, 20));
        students.add(new Student(104, "Bob", 85.0, 22));
        students.add(new Student(101, "Charlie", 92.0, 19));
        students.add(new Student(103, "David", 85.0, 20));

        System.out.println("Sorted by score: ");
        Collections.sort(students, new Student.StudentComparator("score"));
        for (Student student : students) {
            System.out.println(student);
            System.out.println();
        }

        System.out.println(" Sorted by Name : ");
        Collections.sort(students, new Student.StudentComparator("name"));
        for (Student student : students) {
            System.out.println(student);
            System.out.println();
        }

        System.out.println("Sorted by ID: ");
        Collections.sort(students, new Student.StudentComparator("id"));
        for (Student student : students) {
            System.out.println(student);
            System.out.println();
        }

        // sorting employees
        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee("John", 1, 500000, 100);
        employees[1] = new PartTimeEmployee("Alice", 5, 3000, 80, 16);
        employees[2] = new FullTimeEmployee("Paul", 4, 40000, 150);

        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println("Salary :" + employee.calculateSalary());
            System.out.println();
        }

        // Sorting Books
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Ebook("Avengers", "author 1", 2007, 1500));
        books.add(new PrintedBook("The Giver", "author 2", 2008, 890));
        books.add(new Ebook("Harry Potter", "author 3", 1908, 1000));

        Collections.sort(books);
        System.out.println("Sorted books: ");
        for (Book book : books) {
            System.out.println(book);
            System.out.println();
        }

        //Sorting Ebooks
        ArrayList<Ebook> ebooks = new ArrayList<>();
        ebooks.add(new Ebook("Ebook A", "author A", 2009, 89798));
        ebooks.add(new Ebook("Ebook B", "author B", 2010, 10990));
        ebooks.add(new Ebook("Ebook C", "author C", 2011, 19890));

        Collections.sort(ebooks);
        for (Ebook ebook : ebooks) {
            System.out.println("Sorted ebooks " + ebook);
            System.out.println();
        }

        //Sorting PrintedBooks
        ArrayList<PrintedBook> printedBooks = new ArrayList<>();
        printedBooks.add(new PrintedBook("Ebook A", "author A", 1999, 8979));
        printedBooks.add(new PrintedBook("Ebook B", "author B", 1980, 1090));
        printedBooks.add(new PrintedBook("Ebook C", "author C", 2001, 1989));

        Collections.sort(printedBooks);
        for (PrintedBook printedBook : printedBooks) {
            System.out.println("Sorted printed books:  " + printedBook);
            System.out.println();
        }
    }
}

