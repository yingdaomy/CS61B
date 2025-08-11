public class VengefulSLList<Type> extends SSList<Type> {
    SSList<Type> deletedItems;

    public VengefulSLList() {
        super();
        deletedItems = new SSList<Type>();
    }

    @Override
    public Type removeLast() {
        Type x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    public void printLostItems() {
        /** Prints deleted items. */
        deletedItems.print();
    }
}
