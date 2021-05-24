package org.echocat.kata.java.part1;

import business.OrchestrationService;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) throws IOException {
        System.out.println(getHelloWorldText());
    }


    protected static String getHelloWorldText() throws IOException {

        OrchestrationService.INSTANCE.printAll();

        return "Hello world!";
    }

}
