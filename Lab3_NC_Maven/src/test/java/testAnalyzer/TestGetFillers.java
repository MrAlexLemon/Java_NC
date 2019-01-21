package testAnalyzer;

import org.junit.Assert;
import org.junit.Test;
import reflection.Analyzer;


public class TestGetFillers {
    @Test(timeout = 1000)
    public void testWithTimeout() {
        Analyzer obj = new Analyzer();
        obj.getFillers();
    }

    @Test
    public void testFillR() {
        Analyzer obj = new Analyzer();
        int t = obj.getFillers().size();

        Assert.assertEquals(t, 4);
    }

}
