package other.multithreading.StorageTask;

import java.util.concurrent.TimeUnit;

public class Writer extends Thread {

    private final Storage storage;
    private String msg = "";

    public Writer(Storage storage, String name) {
        this.storage = storage;
        setName(name);
    }

    @Override
    public void run() {
        while(true) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            storage.setMessage(msg+="newOne");
        }
    }
}
