package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Book {
    private String title;
    private ArrayList<Author> authors = new ArrayList<>();
    private double price;

    public Book() {
    }

    public Book(String title, ArrayList<Author> authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(price, book.price) == 0 && Objects.equals(title, book.title) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors, price);
    }

    /**
     * Make a comma separated list of authors
     * @return a String of authors
     */
    public String getListOfAuthors() {
        String ListOfAuthors = " ";
        for (int i = 0; i < authors.size(); i++) {
            ListOfAuthors += authors.get(i).getName();
            if (i < authors.size() - 1) {
                ListOfAuthors += ","; //adding a comma if it's not the last element
            }
        }
        return ListOfAuthors;
    }

    @Override
    public String toString() {
        return "Title   : " + title + "\n" +
                "Authors : " + getListOfAuthors() + "\n" +
                "Price   : " + "$" + price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
