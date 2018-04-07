package other.multithreading.Example1;

public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        Thread waiter = new Thread(new Waiter(message));
        Thread notif = new Thread(new Notifier(message));
        waiter.start();
        notif.start();
    }
}
