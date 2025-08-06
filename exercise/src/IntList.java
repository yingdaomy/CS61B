public class IntList {
    int first;
    IntList rest; 

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }


    
    public int size() {
        /** Return the size of the list using recursion. */
        if (rest == null) {
            return 1;
        } else {
            return 1 + this.rest.size();
        }
    }

    public int get(int index) {
        /** Return the ith item of this IntList. */
        if (index == 0) {
            return first;
        } else {
            return get(index - 1);
        }
    }


    public int iterativeSize() {
        /** Return the size of the list using iteration*/
        int totalSize = 0;
        IntList tempNode = this;
        while (tempNode.rest != null) {
            totalSize += 1;
            tempNode = tempNode.rest;
        }
        return totalSize;
    }
}