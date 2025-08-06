public class AList<Type> {

    private Type[] items;
    private int size;
    
    public AList() {
        /** Create an empty list. */
        items = (Type[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        /** Resize the underLying array to the target capacity. */
        Type[] a = (Type[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(Type x) {
        /** Inserts x Typeo the back of the list. */
        if (size == items.length) {
            resize(size * 2);
        }

        items[size] = x;
        size += 1;
    }

    public Type getLast() {
        /** Returns the item from the back of the list. */
        return items[size - 1];
    }

    public Type get(int index) {
        /** Gets the ith item in the list (0 is the front). */
        return items[index - 1];
    }

    public int size() {
        /** Return the number of items in the list. */
        return size;
    }

    public Type removeLast() {
        Type removeItem = items[size - 1];
        size -= 1;
        return removeItem;
    }
}
