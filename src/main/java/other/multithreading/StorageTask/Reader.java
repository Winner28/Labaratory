package other.multithreading.StorageTask;

import java.util.concurrent.TimeUnit;

public class Reader extends Thread {

    private final Storage storage;

    public Reader(Storage storage, String name) {
        this.storage = storage;
        setName(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread: "  + getName()+ ": " + storage.showMessage());
        }
    }
}
