package other.multithreading.Example2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Example2 {

    private static class SingleThreadExecutor {


        private final Queue<Runnable> tasks = new LinkedList<>();
        private final Object lock = new Object();

        public SingleThreadExecutor() {
            new Thread(this::process).start();
        }

        private void process()  {
            synchronized (tasks) {
                if (tasks.isEmpty()) {
                    try {
                        System.out.println("Tasks list is empty!");
                        tasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Running the task!");
                tasks.remove().run();
            }
        }

        public void execute(Runnable task) {
            tasks.add(task);
            synchronized (tasks) {
                System.out.println("We got a new Task to complete!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tasks.notify();
            }
        }
    }

    public static void main(String[] args) {
        SingleThreadExecutor executor = new SingleThreadExecutor();
        System.out.println("Setting the execute!");
        executor.execute(() -> {
            System.out.println("Hello!");
        });

    }
}
