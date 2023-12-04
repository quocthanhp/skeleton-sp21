package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");


        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    /** Adds more things that exceed the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeComplexTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());
        ad1.addLast("a");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("b");
        assertEquals(2, ad1.size());

        ad1.addFirst("c");
        assertEquals(3, ad1.size());

        ad1.addLast("d");
        assertEquals(4, ad1.size());

        ad1.addLast("e");
        assertEquals(5, ad1.size());

        ad1.addFirst("f");
        assertEquals(6, ad1.size());

        ad1.addLast("g");
        assertEquals(7, ad1.size());

        ad1.addLast("h");
        assertEquals(8, ad1.size());

        ad1.addLast("i");
        assertEquals(9, ad1.size());

        ad1.addFirst("j");
        assertEquals(10, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        ad1.addFirst(10);
        // should not be empty
        assertFalse("ad1 should contain 1 item", ad1.isEmpty());

        ad1.removeFirst();
        // should be empty
        assertTrue("ad1 should be empty after removal", ad1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(3);

        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeFirst();

        int size = ad1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();

        assertNull("Should return null when removeFirst is called on an empty Deque,", ad1.removeFirst());
        assertNull("Should return null when removeLast is called on an empty Deque,", ad1.removeLast());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeMultipleTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(6);
        ad1.addFirst(5);
        ad1.addLast(7);
        ad1.addFirst(4);
        ad1.addFirst(3);
        ad1.addLast(8);
        ad1.addFirst(2);
        ad1.addFirst(1);
        ad1.addLast(9);

        ad1.removeLast();
        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeFirst();

        ad1.addLast(8);
        ad1.addLast(9);

        assertEquals(7, ad1.size());
        ad1.printDeque();
    }

    @Test
    public void getTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addFirst("f");
        ad1.addLast("g");
        ad1.addLast("h");
        ad1.addLast("z");

        String itm = ad1.get(8);
        assertEquals("z", itm);
    }

    @Test
    public void iterateTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addFirst("f");
        ad1.addLast("g");
        ad1.addLast("h");
        ad1.addLast("z");

        for (String s : ad1) {
            System.out.println(s);
        }
    }

    @Test
    public void equalityTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");

        ArrayDeque<String> ad2 = new ArrayDeque<>();

        ad2.addLast("a");
        ad2.addLast("b");
        ad2.addFirst("c");

        assertTrue(ad1.equals(ad2));
    }
}
