package deque;

public class LinkedListDeque<T> implements Deque<T>{

    private static class LinkedNode<T> {
        T item;
        LinkedNode<T> next;
        LinkedNode<T> prev;

        public LinkedNode(T item) {
            this.item = item;
            next = this;
            prev = this;
        }
    }

    private LinkedNode<T> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new LinkedNode<T>(null);
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        LinkedNode<T> newNode = new LinkedNode<T>(item);
        newNode.next = sentinel.next;
        newNode.prev = sentinel;
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        LinkedNode<T> newNode = new LinkedNode<>(item);
        newNode.prev = sentinel.prev;
        newNode.next = sentinel;
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        LinkedNode<T> current = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T returnItem = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return returnItem;
    }

    @Override
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T returnItem = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return returnItem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        LinkedNode<T> current = sentinel.next;
        for (int i = 0; i < index; i += 1) {
            current = current.next;
        }
        return current.item;
    }

    private T getRecursiveHelper(LinkedNode<T> current, int index) {
        if (index == 0) {
            return current.item;
        }
        return getRecursiveHelper(current.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }
}
