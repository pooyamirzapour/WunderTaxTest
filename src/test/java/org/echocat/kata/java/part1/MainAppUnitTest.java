package org.echocat.kata.java.part1;
import business.OrchestrationService;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class MainAppUnitTest {

    @Test
    public void testGetHelloWorldText() throws IOException {

         OrchestrationService.INSTANCE.printAll();
        //assertThat(MainApp.getHelloWorldText(), is("Hello world!"));

    }


}
