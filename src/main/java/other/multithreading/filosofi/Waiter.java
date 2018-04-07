package other.multithreading.filosofi;

import java.util.concurrent.TimeUnit;

public class Waiter {


    private static Table table = new Table();
    private static volatile boolean started = true;

    public static void main(String[] args) throws InterruptedException {
        Thread waiter = Thread.currentThread();
        waiter.setName("Waiter");

        System.out.println("Philosophers can came and seat");

        Philosopher mo = createPhilosopher("mo");
        Philosopher kun = createPhilosopher("kun");
        Philosopher lao = createPhilosopher("lao");
        mo.inviteTo(table);
        lao.inviteTo(table);
        kun.inviteTo(table);
        synchronized (table) {
            started = true;
            table.notifyAll();
        }
        while (true) {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Do you need something?");
            if (isTerminated(mo) && isTerminated(kun) && isTerminated(lao)) {
                System.out.println("All philosophers are well-fed");
                break;
            }
        }
        System.out.println("Restaraunt is closing!");
    }

    private static boolean isTerminated(Thread thread) {
        return thread.getState() == Thread.State.TERMINATED;
    }

    public static Philosopher createPhilosopher(String name) {
        Philosopher philosopher = new Philosopher(name);
        philosopher.setBehaviour(() -> {
            try {
                synchronized (table) {
                    while (!started)
                      table.wait();
                }
                Stick leftStick = table.getStickWithLowerIndex(philosopher);
                synchronized (leftStick) {
                    TimeUnit.SECONDS.sleep(1);
                    Stick rightStick = table.getStickWithHigherIndex(philosopher);
                    synchronized (rightStick) {
                        System.out.println("Eating: " + Thread.currentThread()
                                                              .getName());
                        TimeUnit.SECONDS.sleep(5);

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return philosopher;
    }
}
