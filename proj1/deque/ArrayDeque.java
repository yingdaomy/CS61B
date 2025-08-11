package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int head;
    private int tail;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        head = 0;
        tail = 0;
    }


    private void resize(int capacity) {
        /** Resizes the underlying array to the given capacity. */
        T[] newItems = (T[]) new Object[capacity];
        for (int i = 0; i < size; i += 1) {
            newItems[i] = items[(head + 1 + i + items.length) % items.length];
        }
        items = newItems;
        head = items.length - 1;
        tail = size - 1;
    }

    @Override
    public void addFirst(T item) {
        /** Adds an item of type T to the front of the deque. */
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[head] = item;
        head = (head - 1 + items.length) % items.length;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        /** Adds an item of type T to the back of the deque. */
        if (size == items.length) {
            resize(items.length * 2);
        }
        tail = (tail + 1) % items.length;
        items[tail] = item;
        size += 1;
    }


    @Override
    public int size() {
        /** Return the number of items in the deque. */
        return size;
    }

    @Override
    public void printDeque() {
        /** Prints the items in the deque from front to last, separated by a space. */
        for (int i = 0; i < size; i += 1) {
            System.out.print(items[(head + 1 + i + items.length) % items.length] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        /** Removes and returns the item at the front of the deque. */
        if (isEmpty()) {
            return null;
        } else {
            T item = items[(head + 1 + items.length) % items.length];
            items[(head + 1 + items.length) % items.length] = null;
            head = (head + 1 + items.length) % items.length;
            size -= 1;
            if (size <= items.length / 4) {
                resize(items.length / 2);
            }
            return item;
        }
    }

    @Override
    public T removeLast() {
        /** Removes and returns the item at the back of the deque. */
        if (isEmpty()) {
            return null;
        } else {
            T item = items[tail];
            items[tail] = null;
            tail = (tail - 1 + items.length) % items.length;
            size -= 1;
            if (size <= items.length / 4) {
                resize(items.length / 2);
            }
            return item;
        }
    }

    @Override
    public T get(int index) {
        /** Gets the item at the given index, where 0 is the front,
         *  1 is the next item, and so froth. If no such item exists,
         *  returns null.
         */
        if (index < 0 || index >= size) {
            return null;
        } else {
            return items[(head + 1 + index) % items.length];
        }
    }

    private class ArrayDequeIterator implements Iterator<T> {
        int currentIndex;
        int count;

        public ArrayDequeIterator() {
            currentIndex = (head + 1 + items.length) % items.length;
            count = 0;
        }

        public boolean hasNext() {
            return count < size;
        }

        public T next() {
            T returnItem = items[currentIndex];
            currentIndex = (currentIndex + 1) % items.length;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o instanceof ArrayDeque) {
            return false;
        }
        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i += 1) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }
}
