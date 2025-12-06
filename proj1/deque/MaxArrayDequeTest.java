package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;

public class MaxArrayDequeTest {

    public static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            //在这里定义比较规则， 返回负数表示 x < y, 返回 0 表示 x == y, 返回正数表示 x > y
            return o1.compareTo(o2);
        }
    }

    public static class InvIntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            //在这里定义比较规则， 返回负数表示 x > y, 返回 0 表示 x == y, 返回正数表示 x < y
            return o2.compareTo(o1);
        }
    }

    @Test
    public void testMaxArrayDeque() {

        Comparator<Integer> c = new  IntegerComparator();
        Comparator<Integer> c2 = new InvIntegerComparator();

        MaxArrayDeque<Integer> mad = new MaxArrayDeque<>(c);
        mad.addLast(5);
        mad.addLast(10);
        mad.addLast(20);
        mad.addLast(30);
        assertEquals(30, (long) mad.max());
        assertEquals(5, (long) mad.max(c2));
    }
}
