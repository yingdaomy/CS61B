package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> blist = new BuggyAList<Integer>();
        AListNoResizing<Integer> alist = new AListNoResizing<>();
        for (int i = 4; i < 7; i += 1) {
            blist.addLast(i);
            alist.addLast(i);
        }
        assertEquals(blist.size(), alist.size());
        for (int i = 0; i < 3; i += 1) {
            assertEquals(alist.removeLast(), blist.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> alist = new AListNoResizing<Integer>();
        BuggyAList<Integer> blist = new BuggyAList<Integer>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                alist.addLast(randVal);
                blist.addLast(randVal);
                assertEquals(alist.size(), blist.size());
            } else if (operationNumber == 1) {
                int size = alist.size();
                int size2 = blist.size();
                assertEquals(size, size2);
            } else if (operationNumber == 2) {
                if (alist.size() > 0) {
                    int LastVal = alist.getLast();
                    int LastVal2 = blist.getLast();
                    assertEquals(LastVal, LastVal2);
                } else {
                    continue;
                }
            } else {
                if (alist.size() > 0) {
                    int removedVal = alist.removeLast();
                    int removedVal2 = blist.removeLast();
                    assertEquals(removedVal, removedVal2);
                } else {
                    continue;
                }
            }
        }
    }
}
