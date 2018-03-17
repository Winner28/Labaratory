package java8.Example2;

import java8.Example1.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example3 {

    public static class FilterUtil<T> {
        private final List<T> source;
        private final Predicate<T> predicate;

        private FilterUtil(List<T> source, Predicate<T> predicate) {
            this.source = source;
            this.predicate = predicate;
        }

        public static <T> Example3.FilterUtil<T> from(List<T> source) {
            return new Example3.FilterUtil<>(source, t -> true);
        }

        public Example3.FilterUtil<T> filter(Predicate<T> condition) {
            return new FilterUtil<>(source, this.predicate.and(condition));
        }

        public List<T> getSource() {
            List<T> result = new ArrayList<>();
            source.forEach(value -> {
                if (predicate.test(value)) {
                    result.add(value);
                }
            });
            return source;
        }
    }

    @Test
    void justTest() {
        List<Employee> employees = Container.getEmployees();
        List<Employee> result = Example2.FilterUtil.from(employees)
                .filter(employee -> employee.getPerson().getFirstName().equals("Иван"))
                .filter(Employee::testAgeIsEquals30)
                .getSource();

        assertEquals(result.get(0).getPerson().getLastName(), "Мельников");

    }

}
