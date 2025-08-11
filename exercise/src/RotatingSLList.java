public class RotatingSLList<Type> extends SSList<Type>{
    public void rotateRight() {
        Type x = removeLast();
        addFirst(x);
    }
}
