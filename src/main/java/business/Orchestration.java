package business;

import entity.AbstractBook;
import entity.Author;
import entity.Book;
import entity.Magazine;
import service.PrintServiceImpl;
import service.ReadServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum Orchestration {

    INSTANCE;

    private String bookPath = "src/main/resources/books.csv";
    private String authorPath = "src/main/resources/authors.csv";
    private String magazinePath = "src/main/resources/magazines.csv";

    public void setFileToService() throws IOException {
        BufferedReader bookBufferedReader = ReadServiceImpl.INSTANCE.read(bookPath);
        BufferedReader authorBufferedReader = ReadServiceImpl.INSTANCE.read(authorPath);
        BufferedReader magazineBufferedReader = ReadServiceImpl.INSTANCE.read(magazinePath);
        List<AbstractBook> abstractBooks = new ArrayList<>();
        readAuthors(bookBufferedReader);
        readBooks(authorBufferedReader, abstractBooks);
        readMagazines(magazineBufferedReader, abstractBooks);
        PrintServiceImpl.INSTANCE.print(abstractBooks);

    }

    private void readMagazines(BufferedReader magazineBufferedReader, List<AbstractBook> abstractBooks) throws IOException {
        String line;
        do {
            line = magazineBufferedReader.readLine();
            if (line != null) {
                String[] magazineString = line.toString().split(";");
                Magazine magazine = new Magazine();
                magazine.setTitle(magazineString[0].trim());
                magazine.setIsbn(magazineString[1].trim());
                String[] writers = magazineString[2].trim().split(",");
                for (String writer : writers) {
                    Optional<Author> author = Author.getAuthors().stream().filter(f -> f.getEmail().equals(writer)).findAny();
                    if (author.isPresent()) {
                        magazine.addAuthors(author.get());
                    }
                }
                LocalDate dateTime = LocalDate.parse(magazineString[3].trim());
                magazine.setPublishedAt(dateTime);
                abstractBooks.add(magazine);
            }
        } while (line != null);
    }

    private void readBooks(BufferedReader authorBufferedReader, List<AbstractBook> abstractBooks) throws IOException {
        String line;
        do {
            line = authorBufferedReader.readLine();
            if (line != null) {
                String[] bookString = line.toString().split(";");
                Book book = new Book();
                book.setTitle(bookString[0].trim());
                book.setIsbn(bookString[1].trim());
                String[] writers = bookString[2].trim().split(",");
                for (String writer : writers) {
                    Optional<Author> author = Author.getAuthors().stream().filter(f -> f.getEmail().equals(writer)).findAny();
                    if (author.isPresent()) {
                        book.addAuthors(author.get());
                    }
                }
                book.setDescription(bookString[3].trim());
                abstractBooks.add(book);
            }
        } while (line != null);
    }

    private void readAuthors(BufferedReader bookBufferedReader) throws IOException {
        String line;
        do {
            line = bookBufferedReader.readLine();
            if (line != null) {
                String[] authorString = line.toString().split(";");
                Author author =
                        new Author(authorString[0].trim(),
                                authorString[1].trim(),
                                authorString[2].trim());
                author.addAuthor(author);
            }
        } while (line != null);
    }

} 
