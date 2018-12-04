package TestFill;

import filters.FillArrays;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class TestFillSortBack {
    @Test(timeout=1000)
    public void testWithTimeout() {
        FillArrays.fillSortBack(7,11);
    }

    @Test
    public void testFillR() {
        assertNotNull(FillArrays.fillSortBack(7,11));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEx(){
        FillArrays.fillSortBack(-1,11);
    }
}
