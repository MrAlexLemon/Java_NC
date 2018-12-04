package TestFill;
import static junit.framework.Assert.*;
import filters.FillArrays;
import org.junit.Test;

public class TestFillRandom {

    @Test(timeout=1000)
    public void testWithTimeout() {
        FillArrays.fillRandom(7,11);
    }

    @Test
    public void testFillR() {
        assertNotNull(FillArrays.fillRandom(7,11));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEx(){
       FillArrays.fillRandom(-1,11);
    }
}
