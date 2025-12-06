package deque;

public interface Deque<T> {

    /* Adds an item (not equal null) of type T to the front of the deque. */
    public void addFirst(T item);

    /* Adds an item (not equal null) of type T to the back of the deque. */
    public void addLast(T item);

    /* Returns true if deque is empty, false otherwise. */
    default public boolean isEmpty() {
        return size() == 0;
    };

    /* Returns the number of items in the deque. */
    public int size();

    /* Prints the items in the deque from first to last, separated by a space.
       Once all the items have been printed, print out a new line.
     */
    public void printDeque();

    /* Removes and returns the item at the front of the deque. if no such item exists, return null. */
    public T removeFirst();

    /* Removes and returns the item at the back of the deque. if no such item exists, return null. */
    public T removeLast();

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
       if no such item exists, return null.
     */
    public T get(int index);
}
