package testFill;

import filters.FillArrays;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class TestFillSort {
    @Test(timeout=1000)
    public void testWithTimeout() {
        FillArrays.fillSort(7,11);
    }

    @Test
    public void testFillR() {
        assertNotNull(FillArrays.fillSort(7,11));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEx(){
        FillArrays.fillSort(-1,11);
    }
}
