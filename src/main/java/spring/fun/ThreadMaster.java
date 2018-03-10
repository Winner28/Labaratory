package spring.fun;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class ThreadMaster implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("incremented " + i);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("incremented first THREAD" + i);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                System.out.println("incremented second THREAD" + i);
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread2.start();

        thread2.join();
    }
}
