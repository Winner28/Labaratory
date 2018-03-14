package java8.Example1;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.Callable;


public class Example1 {

    @SneakyThrows
    private static String call(Callable<String> call) {
        return call.call();
    }


    @Test
    void commonTest() {
        Person person = new Person("A", "B", 3);
        assertEquals(person.getFirstName(), call(person::getFirstName));

    }

}
