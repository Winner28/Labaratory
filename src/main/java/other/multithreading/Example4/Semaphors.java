package other.multithreading.Example4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Semaphors {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5, false);
        ExecutorService exService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            exService.submit(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("I`m parking!");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("I`m going out!!!");
                }
            });
        }
    }
}


