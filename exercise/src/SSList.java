public class SSList<Type> implements List61B<Type>{

    public class ItemNode {
        Type item;
        ItemNode next;

        public ItemNode(Type i, ItemNode n) {
            item = i;
            next = n;
        }
    }

    private ItemNode sentinel = new ItemNode(null, null);
    int size;


    public SSList() {
        size = 0;
    }

    public SSList(Type x) {
        sentinel.next = new ItemNode(x, null);
        size = 1;
    }

    @Override
    public void addFirst(Type x) {
        /** Adds x to the front of the list. */
        sentinel.next = new ItemNode(x, sentinel.next);
        size += 1;
    }

    @Override
    public Type getFirst() {
        /** Returns the first item in the list. */
        return sentinel.next.item;
    }

    @Override
    public void addLast(Type x) {
        /** Adds x to the end of the list. */
        ItemNode newNode = new ItemNode(x, null);
        ItemNode tempNode = sentinel.next;
        if (tempNode == null) {
            sentinel.next = newNode;
        } else {
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        size += 1;
    }

    @Override
    public int size() {
        /** Return the size of the list. */
        return size;
    }

    private Type get(int index, ItemNode p) {
        if (index == 0) {
            return p.item;
        } else {
            return get(index - 1, p.next);
        }
    }

    @Override
    public Type get(int index) {
        return get(index, sentinel.next);
    }

    @Override
    public void insert(Type x, int position) {
        int index = 0;
        ItemNode p = sentinel;
        while (index != position) {
            p = p.next;
            index += 1;
        }
        ItemNode newNode = new ItemNode(x, p.next);
        p.next = newNode;
    }

    @Override
    public Type getLast() {
        ItemNode p = sentinel.next;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    @Override
    public Type removeLast() {
        ItemNode p = sentinel;
        while (p.next.next != null) {
            p = p.next;
        }
        Type result = p.next.item;
        p.next = null;
        return result;
    }

    @Override
    public void print() {
        for (ItemNode p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }
}
