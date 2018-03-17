package java8.Example2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("WeakerAccess")
public class Example4 {
    private static class LazyCollectionHelper<T, R> {
         private final List<T> source;
         private final Function<T, R> function;

        private LazyCollectionHelper(List<T> source, Function<T, R> function) {
            this.source = source;
            this.function = function;
        }

        public static <T> LazyCollectionHelper<T, T> from (List<T> list) {
            return new LazyCollectionHelper<>(list, null);
        }


        public <U> LazyCollectionHelper map(Function<R, U> function) {
            return new LazyCollectionHelper(source, this.function.andThen(function));
        }

        public List<R> force() {
            List<R> result = new ArrayList<>();
            source.forEach(function::apply);
            return result;
        }
    }

    @Test
    void test() {

    }
}
