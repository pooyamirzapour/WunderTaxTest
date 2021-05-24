package business;

import service.ReadServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public enum  Orchestration {

    INSTANCE;

    private String bookPath="src/main/resources/books.csv";
    private String authorPath="src/main/resources/authors.csv";
    private String magazinePath="src/main/resources/magazines.csv";

    public void setFileToService() throws IOException {
        BufferedReader bookBufferedReader = ReadServiceImpl.INSTANCE.read(bookPath);
        BufferedReader authorBufferedReader = ReadServiceImpl.INSTANCE.read(authorPath);
        BufferedReader magazineBufferedReader = ReadServiceImpl.INSTANCE.read(magazinePath);
    }

} 
