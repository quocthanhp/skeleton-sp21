package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<>(new IntComparator());
        lld1.addFirst(1);
        lld1.addLast(2);
        lld1.addLast(3);

        assertEquals((Integer) 3, lld1.max());
    }

    private static class IntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1 - i2;
        }
    }

}
