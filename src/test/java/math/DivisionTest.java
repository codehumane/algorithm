package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisionTest {

    @Test
    public void calc() throws Exception {
        Assertions.assertEquals(2, Division.calc(8, 3));
        Assertions.assertEquals(0, Division.calc(0, 1));
        Assertions.assertEquals(1, Division.calc(1, 1));
        Assertions.assertEquals(1, Division.calc(2, 2));
        Assertions.assertEquals(2, Division.calc(4, 2));
        Assertions.assertEquals(5, Division.calc(16, 3));
    }
}
