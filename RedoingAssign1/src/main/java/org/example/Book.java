package org.example;

import java.util.Objects;

public class Book {
    String title;
    String authors;
    Double price;

    public Book(String title, String authors, Double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    public Book() {
        this.title = " ";
        this.authors = "";
        this.price = 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(authors, book.authors) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", price=" + price +
                '}';
    }
}
