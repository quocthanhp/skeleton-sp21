package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private static class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> prev;
        public Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    private final Node<T> sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Adds an item to the front of the deque */
    @Override
    public void addFirst(T item) {
        size++;
        Node<T> newNode = new Node<>(item, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
    }

    /** Adds an item to the back of the deque */
    @Override
    public void addLast(T item) {
        size++;
        Node<T> newNode = new Node<>(item, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
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
        Node<T> p = sentinel;
        StringBuilder deque = new StringBuilder();

        while (p.next != sentinel) {
            p = p.next;
            deque.append(p.item).append(" ");
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

        size--;
        T removedItem = sentinel.next.item;
        Node<T> secondFirst = sentinel.next.next;
        sentinel.next = secondFirst;
        secondFirst.prev = sentinel;

        return removedItem;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        size--;
        T removedItem = sentinel.prev.item;
        Node<T> secondLast = sentinel.prev.prev;
        sentinel.prev = secondLast;
        secondLast.next = sentinel;

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

        Node<T> p = sentinel;

        while (p.next != null && index >= 0) {
            p = p.next;
            index--;
        }

        return p.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return getRecursive(index, sentinel.next);
    }

    public T getRecursive(int index, Node<T> p) {
        if (index == 0) {
            return p.item;
        }

        return getRecursive(index - 1, p.next);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        int pos = 0;

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
        for (T i : this) {
            if (i.equals(item)) {
                return true;
            }
        }

        return false;
    }
    @Override
    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//
//        if (o instanceof LinkedListDeque lld) {
//            if (lld.size != this.size) {
//                return false;
//            }
//
//            // check that all of MY items are in the other list
//            for (T x : this) {
//                if (!lld.contains(x)) {
//                    return false;
//                }
//            }
//
//            return true;
//        }
//        return false;

        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }
        LinkedListDeque<?> lld = (LinkedListDeque<?>) o;
        if (lld.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (lld.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }

}
