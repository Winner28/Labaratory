package other.multithreading;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Before sleep");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("After sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        synchronized (thread) {
            thread.wait();
        }
        thread.join();
        System.out.println("Main end");
    }
    }

