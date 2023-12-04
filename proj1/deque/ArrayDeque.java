package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int len = 8;

    public ArrayDeque() {
        items = (T[]) new Object[len];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    /** Adds an item to the front of the deque */
    @Override
    public void addFirst(T item) {
        if (size == len) {
            resize(size * 2);
        }

        items[nextFirst] = item;
        nextFirst = (nextFirst - 1) < 0 ? len - 1 : nextFirst - 1;
        size++;
    }

    /** Adds an item to the back of the deque */
    @Override
    public void addLast(T item) {
        if (size == len) {
            resize(size * 2);
        }

        items[nextLast] = item;
        nextLast = (nextLast + 1) % len;
        size++;
    }

    /** Resize the array to size capacity */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int itemsFromFront = len - nextFirst - 1;
        len = capacity;
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, nextFirst + 1, a, len - itemsFromFront, itemsFromFront);
        nextFirst = len - itemsFromFront - 1;
        items = a;
    }

    /** Returns the number of items in the deque */
    @Override
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line
     */
    @Override
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
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        int removedIndex = (nextFirst + 1) % len;
        T removedItem = items[removedIndex];


        items[removedIndex] = null;
        size--;
        nextFirst = removedIndex;

        return removedItem;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        int removedIndex = (nextLast - 1) < 0 ? len - 1 : nextLast - 1;
        T removedItem = items[removedIndex];
        items[removedIndex] = null;
        size--;
        nextLast = removedIndex;

        return removedItem;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        int getIndex = (nextFirst + 1 + index) % len;

        return items[getIndex];
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int pos = 0;

        @Override
        public boolean hasNext() {
            return pos < size;
        }
        @Override
        public T next() {
            T returnItem = get(pos);
            pos++;
            return returnItem;
        }
    }

    private boolean contains(T item) {
        for (T i : items) {
            if (i == null) {
                continue;
            }

            if (i.equals(item)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o instanceof ArrayDeque ad) {
            if (ad.size != this.size) {
                return false;
            }

            for (T x : this) {
                if (!ad.contains(x)) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }


}
