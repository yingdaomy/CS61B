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
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        AListNoResizing<Integer> rightAList = new AListNoResizing<>();
        for (int i = 4; i <= 6; i += 1) {
            buggyAList.addLast(i);
            rightAList.addLast(i);
        }
        assertEquals(buggyAList.size(), rightAList.size());

        for (int i = 0; i < 3; i += 1) {
            assertEquals(buggyAList.removeLast(), rightAList.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyAList.addLast(randVal);
            } else if (operationNumber == 1) {
                int size1 = L.size();
                int size2 = buggyAList.size();
                assertEquals(size1, size2);
            } else if (operationNumber == 2) {
                if (L.size() == 0 ||  buggyAList.size() == 0) {
                    continue;
                }
                int removeVal1 = L.removeLast();
                int removeVal2 = buggyAList.removeLast();
                assertEquals(removeVal1, removeVal2);
            } else if (operationNumber == 3) {
                if (buggyAList.size() == 0 || L.size() == 0) {
                    continue;
                }
                int getLastVal1 = L.getLast();
                int getLastVal2 = buggyAList.getLast();
                assertEquals(getLastVal1, getLastVal2);
            }
        }
    }
}
