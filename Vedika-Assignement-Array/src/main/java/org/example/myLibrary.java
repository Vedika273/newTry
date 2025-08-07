package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class myLibrary {
    private Book[] books;

    public myLibrary() {
    }

    public myLibrary(Book[] books) {
        this.books = books;
    }

    /**
     * Method that selects a random book
     * @return A book Object at a random index of the books array
     */
    public Book selectBook() {
        if (books == null || books.length == 0) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(books.length);
        return books[index]; //Select a random book from the collection and returns it
    }

    /**
     * Selects a Random book with a specific index, if index is not valid, then returns a random book Object
     * @param idx the index of the book
     * @return a book at a specific index or a random book if the idx isn't valid
     */
    public Book selectBook(int idx) {
        if (books == null || books.length == 0){
            return null;
        }
        if (idx >= 0 && idx < books.length) { //index starts from 0
            return books[idx]; //return book of the specific index
        } else {
            return selectBook();
        }
    }

    /**
     * Calculates the total price of all the books in the library
     *
     * @return the total price of all the books
     */
    public int calcTotalPrice() {
        int total = 0;

        if (getBooks() == null) {
            return total;
        }
        for (Book book : getBooks()) {
            total += (int)(book.getPrice());
        }
        return total;
    }

    /**
     * counts the number of times authors with the given nationality appear in the library’s books
     * @param nationality Author's nationality
     * @return the count of the number of authors with same nationality
     */
    public int countAuthor(String nationality) {
        if (nationality == null || getBooks() == null) {
            return 0;
        }
        int count = 0;
        for (Book book : getBooks()) {
            //illiterate over each other of the current book
            for (Author author : book.getAuthors()) {
                if (author.getNationality().equals(nationality)) {
                    count++;
                }
            }
        }
        return count;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        myLibrary myLibrary = (myLibrary) o;
        return Objects.deepEquals(books, myLibrary.books);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(books);
    }

    @Override
    public String toString() {
        String result = " ";

        for (Book book : books) { //illiterate over each book
            result += "\n" +
                    "Title   :  " + book.getTitle() + "\n" +
                    "Authors : " + book.getListOfAuthors() + "\n" +
                    "Price   :  " + "$"+ book.getPrice() + "\n";
        }
        return result;
    }
}
