package TestFill;

import filters.FillArrays;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class TestFillAddLast {

    @Test(timeout=1000)
    public void testWithTimeout() {
        FillArrays.fillSortAdd(7,11);
    }

    @Test
    public void testFillR() {
        assertNotNull(FillArrays.fillSortAdd(7,11));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEx(){
        FillArrays.fillSortAdd(-1,11);
    }

}
