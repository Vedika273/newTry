package librarycatalogsystem;

import java.util.Objects;

public class PrintedBook extends Book {
    private int numOfPages;

    public PrintedBook() {
        super();
        this.numOfPages = 0;
    }

    public PrintedBook(String title, String author, int publicationYear, int numOfPages) {
        super(title, author, publicationYear);
        this.numOfPages = numOfPages;
    }
    @Override
    public int compareTo(Book o) {
        if (o instanceof PrintedBook) {
            PrintedBook book2 = (PrintedBook) o;
            return Integer.compare(book2.numOfPages, this.numOfPages); //desendingly
        } else {
            return super.compareTo(o);
        }
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }
}
