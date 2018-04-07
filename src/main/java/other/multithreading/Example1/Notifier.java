package other.multithreading.Example1;

import java.util.concurrent.TimeUnit;

public class Notifier implements Runnable {

    private Message message;

    public Notifier(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (message) {
            if (message.isEmpty()) {
                message.setMessage("You got a message!!!");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                message.notify();
            }
        }
    }
}
