package other.multithreading.filosofi;

import lombok.Synchronized;
import lombok.Value;

import java.util.LinkedList;
import java.util.List;

public class Table {

    private final List<Sector> sectors = new LinkedList<>();

    @Synchronized
    public void sit(Philosopher philosopher) {
        int lastSection = sectors.size();
        sectors.add(new Sector(lastSection, new Stick()));

        int philosopherIndex = lastSection + 1;
        sectors.add(new Sector(philosopherIndex, philosopher));
        philosopher.setSectionIndex(philosopherIndex);
    }

    public Stick getLeftStick(Philosopher philosopher) {
        return (Stick) sectors.get(philosopher.getSectionIndex() - 1).getValue();
    }


    public Stick getRightStick(Philosopher philosopher) {
        int index = philosopher.getSectionIndex() + 1;
        return (Stick) sectors.get(index % sectors.size()).getValue();
    }

    public Stick getStickWithLowerIndex(Philosopher philosopher) {
        int index = Math.min(philosopher.getSectionIndex() -1, (philosopher.getSectionIndex() + 1)% sectors.size());
        return (Stick) sectors.get(index).getValue();
    }

    public Stick getStickWithHigherIndex(Philosopher philosopher) {
        int index = Math.max(philosopher.getSectionIndex() -1, (philosopher.getSectionIndex() + 1)% sectors.size());
        return (Stick) sectors.get(index).getValue();
    }


    @Value
    private static class Sector {
        int index;
        Object value;
    }
}
