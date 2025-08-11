public class AList<Type> implements List61B<Type>{

    private Type[] items;
    private int size;
    
    @SuppressWarnings("unchecked")
    public AList() {
        /** Create an empty list. */
        items = (Type[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        /** Resize the underLying array to the target capacity. */
        @SuppressWarnings("unchecked")
        Type[] a = (Type[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    @Override
    public void addLast(Type x) {
        /** Inserts x Typeo the back of the list. */
        if (size == items.length) {
            resize(size * 2);
        }

        items[size] = x;
        size += 1;
    }

    @Override
    public Type getLast() {
        /** Returns the item from the back of the list. */
        return items[size - 1];
    }

    @Override
    public void addFirst(Type x) {
        @SuppressWarnings("unchecked")
        Type[] newItems = (Type[]) new Object[items.length + 1];
        newItems[0] = x;
        size += 1;
        System.arraycopy(items, 0, newItems, 1, size);
        items = newItems;
    }

    @Override
    public Type getFirst() {
        return items[0];
    }

    @Override
    public Type get(int index) {
        /** Gets the ith item in the list (0 is the front). */
        return items[index];
    }

    @Override
    public int size() {
        /** Return the number of items in the list. */
        return size;
    }

    @Override
    public void insert(Type x, int position) {
        @SuppressWarnings("unchecked")
        Type[] newItems = (Type[]) new Object[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, position);
        newItems[position] = x;
        System.arraycopy(items, position, newItems, position + 1, items.length - position);
        items = newItems;
    }

    @Override
    public Type removeLast() {
        Type removeItem = items[size - 1];
        size -= 1;
        return removeItem;
    }
}
