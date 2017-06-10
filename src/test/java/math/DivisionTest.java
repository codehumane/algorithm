package math;

import org.junit.Assert;
import org.junit.Test;

public class DivisionTest {

    @Test
    public void calc() throws Exception {
        Assert.assertEquals(2, Division.calc(8, 3));
        Assert.assertEquals(0, Division.calc(0, 1));
        Assert.assertEquals(1, Division.calc(1, 1));
        Assert.assertEquals(1, Division.calc(2, 2));
        Assert.assertEquals(2, Division.calc(4, 2));
        Assert.assertEquals(5, Division.calc(16, 3));
    }
}
