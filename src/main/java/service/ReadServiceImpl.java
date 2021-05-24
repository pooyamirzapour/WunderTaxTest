package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public enum  ReadServiceImpl implements ReadService {

    INSTANCE;

    public BufferedReader read(String path) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
        } finally {
            if (reader != null)
                reader.close();
        }
        return reader;
    }
}
