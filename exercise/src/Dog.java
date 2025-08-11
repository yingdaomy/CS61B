import java.util.Comparator;

public class Dog implements Comparable<Dog>{
    String name;
    int size;

    public Dog(String n, int s) {
        this.name = n;
        this.size = s;
    }

    /** Return negative number if this < o
     *  Return 0 if this == o
     *  Return positive number if this > o
     */
    @Override
    public int compareTo(Dog uddaDog) {
        return this.size - uddaDog.size;
    }

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }

    public void bark() {
        System.out.println(name + "says: bark!");
    }
}
