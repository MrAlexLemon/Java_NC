package testSort;

import org.junit.Test;
import sorters.MergeSortBubbleUp;


import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TestMergeSortBubbleUp {
    @Test(timeout = 1000)
    public void testWithTimeout() {
        MergeSortBubbleUp obj = new MergeSortBubbleUp();
        obj.sort(new int[]{7, 2, 5, 4, 1, 3});
    }

    @Test
    public void testFillR() {
        int[] arr = new int[]{7, 2, 5, 4, 1, 3};
        int[] carr = Arrays.copyOf(arr,arr.length);
        MergeSortBubbleUp obj = new MergeSortBubbleUp();
        int[] arr2 = obj.sort(carr);

        //assertArrayEquals("Wrong sort!",arr2,arr);
        assertArrayEquals("Wrong sort!",arr2,carr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEx() {
        int[] arr = new int[0];// = new int[]{7, 2, 5, 4, 1, 3};
        MergeSortBubbleUp obj = new MergeSortBubbleUp();
        obj.sort(arr);
    }
}
