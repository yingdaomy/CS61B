package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private final Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.comparator = c;
    }

    public T max() {
        /** Returns the maximum item in the deque as governed by the comparator.
         *  If the MaxArrayDeque is empty, simply return null.
         */
        if (this.isEmpty()) {
            return null;
        } else {
            T maxItem = this.get(0);
            for (int i = 1; i < this.size(); i += 1) {
                T currentItem = this.get(i);
                if (comparator.compare(maxItem, currentItem) > 0) {
                    maxItem = currentItem;
                }
            }
            return maxItem;
        }
    }

    public T max(Comparator<T> c) {
        /** Returns the maximum element in the deque as governed by the parameter Comparator c.
         *  If the MaxArrayDeque is empty, simply return null.
         */
        if (this.isEmpty()) {
            return null;
        } else {
            T maxItem = this.get(0);
            for (int i = 1; i < this.size(); i += 1) {
                T currentItem = this.get(i);
                if (c.compare(maxItem, currentItem) > 0) {
                    maxItem = currentItem;
                }
            }
            return maxItem;
        }
    }
}
