package other.multithreading.Example2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Example2 {

    private static class SingleThreadExecutor {


        private Queue<Runnable> tasks = new LinkedList<>();

        public SingleThreadExecutor() {
            new Thread(this::process).start();
        }

        private void process() {
            while (true) {
                while (!tasks.isEmpty()) {
                    tasks.remove()
                         .run();
                }
            }
        }

        public void execute(Runnable task) {
            tasks.add(task);
            tasks.notify();
        }
    }
}
