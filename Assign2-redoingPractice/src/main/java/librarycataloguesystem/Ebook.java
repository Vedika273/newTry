package librarycataloguesystem;

public class Ebook extends Book{
    private double fileSizeMB;

    public Ebook(double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }

    public Ebook(String title, String author, int publicationYear, double fileSizeMB) {
        super(title, author, publicationYear);
        this.fileSizeMB = fileSizeMB;
    }

}
