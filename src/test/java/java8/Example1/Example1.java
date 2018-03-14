package java8.Example1;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Example1 {

    @SneakyThrows
    private static String call(Callable<String> call) {
        return call.call();
    }

    // Person, Person -> String -> String -> Boolean
    private static Predicate<String> stringPropertyChecker(Function<Person, String> function, Person person) {
        return str -> Objects.equals(function.apply(person), str);
    }

    // Person - > String -> Person -> (String - > Boolean)
    private static Function<Person, Predicate<String>> holyLambdas(Function<Person, String> function) {
        return person -> str -> function.apply(person).equals(str);
    }


    @Test
    void commonTest() {
        Person person = new Person("A", "B", 3);
        assertEquals(person.getFirstName(), call(person::getFirstName));
    }

    @Test
    void secondTest() {
        Person person = new Person("a", "b", 10);
        Supplier<String> supl = person::getFirstName;
        Function<Person, String> func = Person::getFirstName;
        Predicate<String> predicate = stringPropertyChecker(func, person);
        assertTrue(predicate.test(person.getFirstName()));
        assertEquals(supl.get(), person.getFirstName());
        assertEquals(func.apply(person), person.getFirstName());
    }

    @Test
    void thirdTest() {
        Person pers = new Person("a", "b", 10);
        Function<Person, String> function =
                person -> person.getFirstName()
                        .concat(person.getLastName());

        Function<Person, Predicate<String>> predicateFunction = holyLambdas(function);
        Predicate<String> pr = predicateFunction.apply(pers);
        assertFalse(pr.test("lol"));
        assertTrue(pr.test(pers.getFirstName().concat(pers.getLastName())));
    }


}
