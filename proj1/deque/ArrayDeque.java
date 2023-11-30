package deque;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int len = 8;

    public ArrayDeque() {
        items = (Item[]) new Object[len];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /** Adds an item to the front of the deque */
    public void addFirst(Item item) {
        if (size == len) {
            resize(size * 2);
        }

        items[nextFirst] = item;
        nextFirst = (nextFirst - 1) < 0 ? len - 1 : nextFirst - 1;
        size++;
    }

    /** Adds an item to the back of the deque */
    public void addLast(Item item) {
        if (size == len) {
            resize(size * 2);
        }

        items[nextLast] = item;
        nextLast = (nextLast + 1) % len;
        size++;
    }

    /** Resize the array to size capacity */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        int itemsFromFront = len - nextFirst - 1;
        len = capacity;
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, nextFirst + 1, a, len - itemsFromFront, itemsFromFront);
        nextFirst = len - itemsFromFront - 1;
        items = a;
    }

    /** Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line
     */
    public void printDeque() {
        StringBuilder deque = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int index = (nextFirst + 1 + i) % len;
            deque.append(items[index]).append(" ");
        }

        deque = new StringBuilder(deque.toString().stripTrailing());

        System.out.println(deque);
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null */
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }

        int removedIndex = (nextFirst + 1) % len;
        Item removedItem = items[removedIndex];


        items[removedIndex] = null;
        size--;
        nextFirst = removedIndex;

        return removedItem;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null */
    public Item removeLast() {
        if (size == 0) {
            return null;
        }

        int removedIndex = (nextLast - 1) < 0 ? len - 1 : nextLast - 1;
        Item removedItem = items[removedIndex];
        items[removedIndex] = null;
        size--;
        nextLast = removedIndex;

        return removedItem;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     */
    public Item get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        int getIndex = (nextFirst + 1 + index) % len;

        return items[getIndex];
    }

}
