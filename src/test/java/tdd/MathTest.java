package tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tdd.first_task.Math;

class MathTest {

    @ParameterizedTest
    @CsvSource({"10,2,5", "200,200,1"})
    void devide(double a, double b, double expected) {
        assertEquals(expected, Math.devide(a, b));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({"10,2,5", "200,200,1"})
    void disabledDevide(double a, double b, double expected) {
        assertEquals(expected, Math.devide(a, b));
    }

    @Test
    void testException() {
        assertThrows(ArithmeticException.class, ()-> {Math.devide(3,0);});
    }
}