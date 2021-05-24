package business;

import entity.AbstractBook;
import entity.Author;
import entity.Book;
import entity.Magazine;
import service.PrintServiceImpl;
import service.ReadServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum OrchestrationService {

    INSTANCE;

    private String bookPath = "src/main/resources/org/echocat/kata/java/part1/data/books.csv";
    private String authorPath = "src/main/resources/org/echocat/kata/java/part1/data/authors.csv";
    private String magazinePath = "src/main/resources/org/echocat/kata/java/part1/data/magazines.csv";

    public void printAll() throws IOException {
        BufferedReader bookBufferedReader = ReadServiceImpl.INSTANCE.read(bookPath);
        BufferedReader authorBufferedReader = ReadServiceImpl.INSTANCE.read(authorPath);
        BufferedReader magazineBufferedReader = ReadServiceImpl.INSTANCE.read(magazinePath);
        List<AbstractBook> abstractBooks = new ArrayList<>();
        readAuthors(authorBufferedReader);
        readBooks(bookBufferedReader, abstractBooks);
        readMagazines(magazineBufferedReader, abstractBooks);
        PrintServiceImpl.INSTANCE.print(abstractBooks);

    }

    private void readMagazines(BufferedReader magazineBufferedReader, List<AbstractBook> abstractBooks) throws IOException {
        String line;
        int index=0;
        do {
            line = magazineBufferedReader.readLine();
            if ( index!=0&&  line != null) {
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
                String replace = magazineString[3].trim().replace(".", "-");
                DateTimeFormatter simpleDateFormat =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate localDate = LocalDate.parse(replace, simpleDateFormat);
                magazine.setPublishedAt(localDate);
                abstractBooks.add(magazine);
            }
            index++;
        } while (line != null);
    }

    private void readBooks(BufferedReader bookBufferedReader, List<AbstractBook> abstractBooks) throws IOException {
        String line;
        int index=0;
        do {
            line = bookBufferedReader.readLine();
                if (index!=0 && line != null) {
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
            index++;


        } while (line != null);
    }

    private void readAuthors(BufferedReader bookBufferedReader) throws IOException {
        String line;
        int index=0;

        do {
            line = bookBufferedReader.readLine();
            if ( index!=0 &&  line != null) {
                String[] authorString = line.toString().split(";");
                Author author =
                        new Author(authorString[0].trim(),
                                authorString[1].trim(),
                                authorString[2].trim());
                author.addAuthor(author);

            }
            index++;

        } while (line != null);
    }

} 
