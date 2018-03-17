package java8.Example2;

import java8.Example1.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Example2 {
    public static class FilterUtil<T> {
        private final List<T> source;

        private FilterUtil(List<T> source) {
            this.source = source;
        }

        public static <T> FilterUtil<T> from(List<T> source) {
            return new FilterUtil<>(source);
        }

        public FilterUtil<T> filter(Predicate<T> condition) {
            List<T> result = new ArrayList<>();
            source.forEach(value -> {
                if (condition.test(value)) {
                    result.add(value);
                }
            });
            return from(result);
        }

        public List<T> getSource() {
            return source;
        }
    }

    @Test
    void justTest() {
        List<Employee> employees = Container.getEmployees();
        List<Employee> result = FilterUtil.from(employees)
                .filter(employee -> employee.getPerson().getFirstName().equals("Иван"))
                .filter(Employee::testAgeIsEquals30)
                .getSource();

        assertEquals(result.get(0).getPerson().getLastName(), "Мельников");

    }
}
