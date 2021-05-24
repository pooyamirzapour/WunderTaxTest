package service;

import entity.AbstractBook;

import java.util.List;

public enum  PrintServiceImpl implements PrintService {

    INSTANCE;

    public void print(List<AbstractBook> abstractBookList) {
        System.out.println(abstractBookList);
    }
}
