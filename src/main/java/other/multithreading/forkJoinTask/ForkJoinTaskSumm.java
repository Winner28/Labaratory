package other.multithreading.forkJoinTask;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForkJoinTaskSumm {
    public static void main(String[] args) {
        int[] data = IntStream.rangeClosed(0, 1_000_000)
                              .map(i -> 1)
                              .toArray();
        Integer invoke = new ForkJoinPool().invoke(new ForkJoinSummingTask(data));
        System.out.println(invoke);
    }


    private static class ForkJoinSummingTask extends RecursiveTask<Integer> {
        private static final int SEQUENTIAL_THRESHOLD = 1_000;
        private final int[] data;
        private final int fromInclusive;
        private final int toInclusive;

        public ForkJoinSummingTask(int[] data) {
            this(data, 0, data.length - 1);
        }

        private ForkJoinSummingTask(int[] data, int fromInclusive, int toInclusive) {
            this.data = data;
            this.fromInclusive = fromInclusive;
            this.toInclusive = toInclusive;
        }

        @Override
        protected Integer compute() {
            if (toInclusive - fromInclusive < SEQUENTIAL_THRESHOLD) {
                int sum =  Arrays.stream(data)
                                 .sum();
                return sum;
            } else {
                ForkJoinSummingTask left  = new ForkJoinSummingTask(data, fromInclusive, data.length /2);
                ForkJoinSummingTask right = new ForkJoinSummingTask(data, data.length / 2 + 1, toInclusive);

                ForkJoinTask.invokeAll(left, right);


               return left.join() + right.join();
            }
        }
    }


}
