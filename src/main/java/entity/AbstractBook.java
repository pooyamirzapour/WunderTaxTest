package entity;

import java.util.Date;
import java.util.List;

public abstract class AbstractBook {

    private String title;
    private String isbn;
    private List<Author> authors;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthors(Author author) {
        this.authors.add( author);
    }



    @Override
    public String toString() {
        return "AbstractBook{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }
}
