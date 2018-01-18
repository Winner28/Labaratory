package tdd.first_task;

public class Math {

    public static double devide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Can`t devide by zero");
        return a/b;
    }
}
