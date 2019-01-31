package testSort;

import org.junit.Test;
import sorters.BubbleSortDown;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestBubbleSortDown {

    @Test(timeout = 1000)
    public void testWithTimeout() {
        BubbleSortDown obj = new BubbleSortDown();
        obj.sort(new int[]{7, 2, 5, 4, 1, 3});
    }

    @Test
    public void testFillR() {
        int[] arr = new int[]{7, 2, 5, 4, 1, 3};
        int[] carr = Arrays.copyOf(arr,arr.length);
        BubbleSortDown obj = new BubbleSortDown();
        int[] arr2 = obj.sort(carr);

        //assertArrayEquals("Wrong sort!",arr2,arr);
        assertArrayEquals("Wrong sort!",arr2,carr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEx() {
        int[] arr = new int[0];// = new int[]{7, 2, 5, 4, 1, 3};
        BubbleSortDown obj = new BubbleSortDown();
        obj.sort(arr);
    }

}
