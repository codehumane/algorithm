package math;

import org.junit.Assert;
import org.junit.Test;

public class ModularInverseTest {

    @Test
    public void get() throws Exception {
        Assert.assertEquals(5, ModularInverse.get(3, 7));
    }

    @Test
    public void get_역수가_존재하지_않으면_음수1을_반환해야_한다() throws Exception {
        Assert.assertEquals(-1, ModularInverse.get(2, 6));
    }
}