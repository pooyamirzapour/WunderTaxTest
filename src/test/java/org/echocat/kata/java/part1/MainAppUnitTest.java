package org.echocat.kata.java.part1;

import business.OrchestrationService;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;

public class MainAppUnitTest {

    @Test
    public void testGetHelloWorldText() throws IOException {

         OrchestrationService.INSTANCE.printAll();
        //assertThat(MainApp.getHelloWorldText(), is("Hello world!"));

    }


}
