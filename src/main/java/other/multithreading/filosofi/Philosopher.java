package other.multithreading.filosofi;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Philosopher extends Thread {

    private int sectionIndex;
    private Runnable behaviour;

    public Philosopher(String name) {
        super(name);
    }

    @Override
    public void run() {
        behaviour.run();
    }

    public void inviteTo(Table table) {
        table.sit(this);
        this.start();
    }
}
