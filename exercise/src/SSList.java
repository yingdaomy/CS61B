public class SSList<Type> {

    public class IntNode {
        int item;
        IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel = new IntNode(2025, null);
    int size;


    public SSList() {
        size = 0;
    }

    public SSList(int x) {
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        /** Adds x to the front of the list. */
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public int getFirst() {
        /** Returns the first item in the list. */
        return sentinel.next.item;
    }

    public void addLast(int x) {
        /** Adds x to the end of the list. */
        IntNode newNode = new IntNode(x, null);
        IntNode tempNode = sentinel.next;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = newNode;
        size += 1;
    }

    public int size() {
        /** Return the size of the list. */
        return size;
    }

    public static void main(String[] args) {
        SSList<Integer> L = new SSList<Integer>(10);
        L.addFirst(15);
        L.addFirst(20);
        System.out.println(L.getFirst());
    }
}
