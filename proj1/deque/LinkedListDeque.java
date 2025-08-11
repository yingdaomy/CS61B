package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>{

    private class ItemNode {
        public T item;
        public ItemNode next;
        public ItemNode prev;

        public ItemNode(T item, ItemNode next, ItemNode prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    ItemNode head;
    ItemNode tail;
    int size;

    public LinkedListDeque() {
        head = new ItemNode(null, null, null);
        tail = new ItemNode(null, null, null);
        head.next = tail;
        head.prev = tail;
        tail.prev = head;
        tail.next = head;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        /* Adds an item of type T to the front of the deque. */
        ItemNode newNode = new ItemNode(item, null, null);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        /* Adds an item of type T to the back of the deque. */
        ItemNode newNode = new ItemNode(item, null, null);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size += 1;
    }

    @Override
    public int size() {
        /* Return the number of items in the deque. */
        return size;
    }

    @Override
    public void printDeque() {
        /* Prints the items in the deque from first to last, separated by a space. Once
           all the items have been printed, print out a new line.
         */
        ItemNode current = head.next;
        while (current != tail) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        /* Removes and returns the item at the front of the deque. If no such item exists,
           returns null.
         */
        if (isEmpty()) {
            return null;
        } else {
            ItemNode firstNode = head.next;
            head.next.next.prev = head;
            head.next = head.next.next;
            size -= 1;
            return firstNode.item;
        }
    }

    @Override
    public T removeLast() {
        /* Removes and returns the item at the back of the deque. If no such item exists,
           returns null.
        */
        if (isEmpty()) {
            return null;
        } else {
            ItemNode lastNode = tail.prev;
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            size -= 1;
            return lastNode.item;
        }
    }

    @Override
    public T get(int index) {
        /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
           If no such item exists, returns null. Must not alter the deque!
         */
        int currentIndex = 0;
        ItemNode currentNode = head.next;
        if (currentNode == tail || index > size - 1) {
            return null;
        }
        while (index > currentIndex) {
            currentNode = currentNode.next;
            currentIndex += 1;
        }
        if (currentNode == tail) {
            return null;
        } else {
            return currentNode.item;
        }
    }

    private T getRecursiveHelper(int index, ItemNode currentNode) {
        if (index == 0) {
            return currentNode.item;
        } else if (currentNode == tail) {
            return null;
        } else {
            return getRecursiveHelper(index - 1, currentNode.next);
        }
    }

    public T getRecursive(int index) {
        /* Same as get, but uses recursion. */
        return getRecursiveHelper(index, head.next);
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        ItemNode currentNode;
        public LinkedListDequeIterator() {
            currentNode = head.next;
        }

        public boolean hasNext() {
            return currentNode != tail;
        }

        public T next() {
            T returnItem = currentNode.item;
            currentNode = currentNode.next;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinkedListDeque)) {
            return false;
        }
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (this.size != other.size()) {
            return false;
        }
        for (int i = 0; i < this.size; i += 1) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }
}

