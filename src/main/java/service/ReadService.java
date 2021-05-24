package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface ReadService {

    BufferedReader read(String path) throws IOException;
} 
