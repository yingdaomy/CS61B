import java.util.List;
import java.util.ArrayList;

public class ArrayMap<K, V> implements Map61B<K, V> {
    
    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    /**
     * Return the index of the key, if it exists. Otherwise return -1.
     **/
    private int keyIndex(K key) {
        for (int i = 0; i < size; i += 1) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean containsKey(K key) {
        int index = keyIndex(key);
        return index > -1;
    }

    @Override
    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size += 1;
        } else {
            values[index] = value;
        }
    }

    @Override
    public V get(K key) {
        int index = keyIndex(key);
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<K> keys() {
        List<K> keyList = new ArrayList<K>();
        for (int i = 0; i < size; i += 1) {
            keyList.add(keys[i]);
        }
        return keyList;
    }
}
