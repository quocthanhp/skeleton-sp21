package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> comparator;
    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {
        if (isEmpty()) {
            return null;
        }

        int maxIndex = 0;

        for (int i = 0; i < size(); i++) {
            int cmp = comparator.compare(get(i), get(maxIndex));
            if (cmp > 0) {
                maxIndex = i;
            }
        }

        return get(maxIndex);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }

        int maxIndex = 0;

        for (int i = 0; i < size(); i++) {
            int cmp = c.compare(get(i), get(maxIndex));
            if (cmp > 0) {
                maxIndex = i;
            }
        }

        return get(maxIndex);
    }

}
