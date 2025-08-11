public interface List61B<Type> {

    public void addFirst(Type x);
    
    public void addLast(Type x);

    public Type getFirst();

    public Type getLast();

    public Type get(int index);

    public int size();

    public Type removeLast();

    public void insert(Type x, int position);

    default public void print() {
        for (int i = 0; i < size(); i += 1) {
            System.out.print(get(i) + "");
        }
        System.out.println();
    }
}
