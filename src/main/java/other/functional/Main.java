package other.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public List<Integer> doubling(List<Integer> nums) {
        return nums.stream()
                .map(integer -> integer*2)
                .collect(Collectors.toList());
    }

    public static int doubleValue(int s) {
        return s * s;
    }

    public List<String> addStar(List<String> strings) {
        return strings.stream().map(value -> value + "*").collect(Collectors.toList());
    }

    public List<String> copies3(List<String> strings) {
        return strings.stream().map(str -> {
            String result = "";
            for (int i = 0; i < 3; i++) {
                result += str;
            }
            return result;
        }).collect(Collectors.toList());
    }

    public List<Integer> math1(List<Integer> nums) {
        return nums.stream().map(value -> (value + 1) * 10).collect(Collectors.toList());
    }

    public List<String> moreY(List<String> strings) {
        return strings.stream().map(str -> "y" + str + "y").collect(Collectors.toList());
    }

    public static List<Integer> rightDigit(List<Integer> nums) {
        return nums.stream().map(value -> {
            for (int i = 0; i < String.valueOf(value).length(); i++) {
                value %= 10;
            }
            return value;
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(square56(Arrays.asList(3,1,4)));
    }


    public List<String> lower(List<String> strings) {
        return strings.stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    public List<String> noX(List<String> strings) {
        return strings.stream().map(s -> s.replace("x", "")).map(String::trim).collect(Collectors.toList());
    }
    public static List<String> noYY(List<String> strings) {
        return strings.stream()
                .filter(str -> str.contains("y")).filter(str -> str.contains("y"))
                .map(str -> str + "y")
                .collect(Collectors.toList());
    }

    public static List<Integer> square56(List<Integer> nums) {
        return nums.stream().map(val -> (val * val) + 10).filter(val -> val%10!=6 && val%10!=5).collect(Collectors.toList());

    }


}








