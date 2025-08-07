package librarycatalogsystem;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Book implements Comparable<Book> {

    private String title;
    private String author;
    private int publicationYear;

    public Book() {
        super();
        this.title = " ";
        this.author = " ";
        this.publicationYear = 2000;
    }

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }


    public int compareTo(Book o) {
        return Integer.compare(this.publicationYear , o.getPublicationYear());
    }

    @Override
    public String toString() {
        return "Book" + "\n" + "title: " + title + "\n" + "author : " + author + "\n" +
                "Publication Year : " + publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }


    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
