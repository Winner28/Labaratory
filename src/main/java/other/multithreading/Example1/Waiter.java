package other.multithreading.Example1;

public class Waiter implements Runnable {


    private Message message;

    public Waiter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (message) {
            if (message.isEmpty()) {
                try {
                    System.out.println("Waiting for message...");
                    message.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("We got that message, right on rock upons you!");
        System.out.println(message.getMessage());
    }
}
