package tdd.second_task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ranges {

    private long leftBound;
    private long rightBound;

    public Ranges(long leftBound, long rightBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }


    public boolean isBeforeRange(Ranges otherRange) {
        return this.leftBound > otherRange.rightBound;
    }

    public boolean isAfterRange(Ranges range) {
        return this.rightBound < range.leftBound;
    }

    public long getLowerBound() {
        return leftBound;
    }

    public long getUpperBound() {
        return rightBound;
    }

    public boolean isConcurrent(Ranges range) {
        return !isBeforeRange(range) && !isAfterRange(range);
    }

    public boolean contains(long value) {
        return value<=rightBound && value>=leftBound;
    }

    public List<Long> asList() {
        List<Long> rangeList = new ArrayList<>();
        for (long i = leftBound; i<rightBound; i++) {
            rangeList.add(i);
        }
        return rangeList;
    }

    public Iterator<Long> asIterator() {
        return asList().iterator();
    }


}
