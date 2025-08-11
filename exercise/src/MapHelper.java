import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class MapHelper{
    /* Write the following three methods:
     * get(key) : Return item in map if it exists.
     * maxKey() : Return max of all keys. Works only if x and y have comparable data.
     */

    public static <K, V> V get(Map61B<K, V> sim, K key) {
        if (sim.containsKey(key)) {
            return sim.get(key);
        }
        return null;
    }

    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> map) {
        List<K> keylist = map.keys();
        K largest = keylist.get(0);
        for (K k : keylist) {
            if (k.compareTo(largest) > 0) {
                largest = k;
            }
        }
        return largest;
    }

    @Test
    public void testGet() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        Integer actual = MapHelper.get(m, "fish");
        Integer expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxKey() {
        Map61B<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);

        String actual = MapHelper.maxKey(m);
        String expected = "house";
        assertEquals(expected, actual);
    }
}
