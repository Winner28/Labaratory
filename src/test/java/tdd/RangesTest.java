package tdd;

import org.junit.jupiter.api.Test;
import tdd.second_task.Ranges;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RangesTest {

    private Ranges a = new Ranges(10,100);
    private Ranges b = new Ranges(-10,200);


    @Test
    void isBeforeRange() {
        assertEquals(a.isBeforeRange(b), false);
    }

    @Test
    void isAfterRange() {
        assertEquals(a.isAfterRange(b), false);
    }

    @Test
    void getLowerBound() {
        assertEquals(a.getLowerBound(), 10);
    }

    @Test
    void getUpperBound() {
        assertEquals(a.getUpperBound(), 100);
    }

    @Test
    void isConcurrent() {
        assertEquals(a.isConcurrent(b), true);
    }

    @Test
    void contains() {
        assertEquals(a.contains(50), true);
    }

    @Test
    void asList() {
        assertEquals(a.asList(), generateListFromSourceRAange(a));
    }

    @Test
    void asIterator() {
        assertNotEquals(a.asIterator(), generateListFromSourceRAange(a).iterator());
    }

    List<Long> generateListFromSourceRAange(Ranges range) {
        List<Long> rangeList = new ArrayList<>();
        for (long i = range.getLowerBound(); i < range.getUpperBound(); i++) {
            rangeList.add(i);
        }
        return rangeList;
    }
}