package testAnalyzer;

import org.junit.Assert;
import org.junit.Test;
import reflection.Analyzer;

public class TestGetSorters {

    @Test(timeout = 1000)
    public void testWithTimeout() {
        Analyzer obj = new Analyzer();
        obj.getSorts();
    }

    @Test
    public void testFillR() {
        Analyzer obj = new Analyzer();
        int t = obj.getSorts().size();

        Assert.assertEquals(t, 8);
    }

}
