package other.multithreading.StorageTask;

public class Storage {

    private volatile String message;

    private final Object $writeLock = new Object();
    private final Object $readLock = new Object();

    public void setMessage(final String message) {
        System.out.println("Trying to write a message!");
        synchronized ($writeLock) {
            synchronized ($readLock) {
                System.out.println("Finally i can write a message!");
                this.message = message;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                $readLock.notifyAll();
                $writeLock.notifyAll();
            }
        }
    }

    private boolean isMessageEmpty() {
        synchronized ($readLock) {
            return message == null || message.isEmpty();
        }
    }

    public String showMessage() {
        if (isMessageEmpty()) {
            try {
                System.out.println(Thread.currentThread()
                                         .getName() + ": " + "Waiting for message");
                synchronized ($readLock) {
                    $readLock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread()
                                     .getName() + ": " + "Got it!!!");
        }

        synchronized ($writeLock) {
            try {
                System.out.println("Reading...");
                $writeLock.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return this.message;
    }

    public static void main(String[] args) throws InterruptedException {
        Storage storage = new Storage();

        Writer writer = new Writer(storage, "Writer");
        Reader reader = new Reader(storage, "Reader-0");
        Reader reader1 = new Reader(storage, "Reader-1");
        Reader reader2 = new Reader(storage, "Reader-2");
        Reader reader3 = new Reader(storage, "Reader-3");

        reader.start();
        reader1.start();
        reader2.start();
        reader3.start();
        Thread.sleep(3000);
        writer.start();

    }


}
