package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic array list tests. */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     *  finally printing the results.
     */
    public void addIsEmptySizeTest() {

        ArrayDeque<String> ad = new  ArrayDeque<>();

        assertTrue("A newly initialized arrayDeque should be empty", ad.isEmpty());

        ad.addFirst("front");

        assertEquals(1, ad.size());
        assertFalse("ad should now contain 1 item", ad.isEmpty());

        ad.addLast("middle");
        assertEquals(2, ad.size());

        ad.addLast("back");
        assertEquals(3, ad.size());

        System.out.println("Printing out the deque: ");
        ad.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that ad is empty afterwards. */
    public void addRemoveTest() {
        ArrayDeque<String> ad = new  ArrayDeque<>();

        assertTrue("ad should be empty upon initialization", ad.isEmpty());

        ad.addFirst("front");
        assertFalse("ad should contain 1 item", ad.isEmpty());

        ad.removeFirst();
        assertTrue("ad should be empty after removal", ad.isEmpty());
    }

    @Test
    /** Tests removing from an empty deque */
    public void removeEmptyTest() {
        ArrayDeque<String> ad = new  ArrayDeque<>();
        ad.addFirst("front");

        ad.removeLast();
        ad.removeFirst();
        ad.removeLast();
        ad.removeFirst();

        int size = ad.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, ad.size());
    }

    @Test
    /** Check if you can create ArrayDeques wtih different parameterized types */
    public void multipleParamTest() {
        ArrayDeque<String> ad1 = new  ArrayDeque<>();
        ArrayDeque<Double> ad2 = new ArrayDeque<>();
        ArrayDeque<Boolean> ad3 = new ArrayDeque<>();

        ad1.addFirst("string");
        ad2.addFirst(3.14159);
        ad3.addFirst(true);

        String s = ad1.removeFirst();
        double d = ad2.removeFirst();
        boolean b = ad3.removeFirst();
    }

    @Test
    /** check if null is returned when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {
        ArrayDeque<Integer> ad = new  ArrayDeque<>();

        assertEquals("Should return null when removeFirst is called on an empty Deque", null, ad.removeFirst());
        assertEquals("should return null when removeLast is called on an empty Deque", null, ad.removeLast());

    }

    @Test
    /** Add large number of elements to deque; check if order is correct. */
    public void bigArrayDequeTest() {
        ArrayDeque<Integer> ad = new  ArrayDeque<>();

        for (int i = 0; i < 100; i += 1) {
            ad.addFirst(i);
        }

        for (int i = 0; i < 50; i += 1) {
            assertEquals("Should have the same value", i, (int) ad.removeLast());
        }

        for (int i = 99; i > 50; i -= 1) {
            assertEquals("Should have the same value", i, (int) ad.removeFirst());
        }
    }
}
