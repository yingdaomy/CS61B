import java.util.List;

public interface Map61B<K, V> {
    
    public void put(K key, V value); // Associate key with value.

    public boolean containsKey(K key); // Checks if map contains the key.

    public V get(K key); // Returns value, assuming key exists.

    public int size(); // Returns a list of all keys.

    public List<K> keys(); // Returns number of keys.
}
