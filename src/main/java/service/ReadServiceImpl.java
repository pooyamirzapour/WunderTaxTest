package service;

import org.springframework.util.ResourceUtils;

import java.io.*;

public enum  ReadServiceImpl implements ReadService {

    INSTANCE;

    public BufferedReader read(String path) throws IOException {
        BufferedReader reader = null;
        try {

            return new BufferedReader(new FileReader(path));
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
