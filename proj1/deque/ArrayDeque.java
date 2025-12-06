package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private class DequeIterator implements Iterator<T> {

        private int currentIndex;

        public DequeIterator() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            T returnItem = get(currentIndex);
            currentIndex += 1;
            return returnItem;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private T[] items;
    private int front;
    private int rear;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        front = 0;
        rear = 0;
        size = 0;
    }


    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int currentIndex = this.front;
        int pos = 0;
        while (currentIndex != rear) {
            newItems[pos]  = items[currentIndex];
            pos += 1;
            currentIndex = (currentIndex + 1) % items.length;
        }
        front = 0;
        rear = size;
        this.items = newItems;
    }

    @Override
    public void addFirst(T item) {
        front = (front - 1 + items.length) % items.length;
        items[front] = item;
        size += 1;
        if ((double) size / items.length >= 0.75) {
            resize(size * 2);
        }
    }

    @Override
    public void addLast(T item) {
        items[rear] = item;
        rear = (rear + 1) % items.length;
        size += 1;
        if ((double) size / items.length >= 0.75) {
            resize(size * 2);
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = front; i != rear; i = (i + 1) % items.length) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T returnItem = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        size -= 1;
        if ((double) size / items.length < 0.25 && items.length > 16) {
            resize(items.length / 2);
        }
        return returnItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        rear = (rear - 1 + items.length) % items.length;
        T returnItem =  items[rear];
        size -= 1;
        items[rear] = null;
        if ((double) size / items.length < 0.25 && items.length > 16) {
            resize(items.length / 2);
        }
        return returnItem;
    }

    @Override
    public T get(int index) {
        return items[(front + index) % items.length];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof ArrayDeque)) {
            return false;
        }
        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (this.size != other.size()) {
            return false;
        }
        for (int i = front; i != rear; i = (i + 1) % items.length) {
            if (!items[i].equals(other.items[i])) {
                return false;
            }
        }
        return true;
    }

}
