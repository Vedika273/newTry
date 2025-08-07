package librarycatalogsystem;

public class Ebook extends Book{
    private double fileSizeMB;

    public Ebook() {
        this.fileSizeMB = 0.0;
    }

    public Ebook(String title, String author, int publicationYear, double fileSizeMB) {
        super(title, author, publicationYear);
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public int compareTo(Book o) {
        if (o instanceof Ebook) {
            Ebook otherEbook = (Ebook) o;  //downcasting (Book -> Ebook)
            return Double.compare(this.fileSizeMB, otherEbook.fileSizeMB);
        }
        else {
            return super.compareTo(o);
        }
    }
    public double getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }

}
