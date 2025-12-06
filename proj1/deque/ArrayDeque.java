package deque;

public class ArrayDeque<T> implements Deque<T> {

    private T[] items;
    private int front;
    private int rear;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[10];
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
    public boolean isEmpty() {
        return front == rear;
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

}
