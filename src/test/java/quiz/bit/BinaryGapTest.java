package quiz.bit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import quiz.bit.BinaryGap;

@Slf4j
public class BinaryGapTest {

    @Test
    public void compute_15() throws Exception {
        // Given
        BinaryGap binaryGap = new BinaryGap();
        log.info(Integer.toBinaryString(15));

        // When
        int computed = binaryGap.computeByMySolution(15);

        // Then
        Assert.assertEquals(0, computed);
    }

    @Test
    public void compute_1041() throws Exception {
        // Given
        BinaryGap binaryGap = new BinaryGap();
        log.info(Integer.toBinaryString(1041));

        // When
        int computed = binaryGap.computeByMySolution(1041);

        // Then
        Assert.assertEquals(5, computed);
    }

    @Test
    public void compute_561892() throws Exception {
        // Given
        BinaryGap binaryGap = new BinaryGap();
        log.info(Integer.toBinaryString(561892));

        // When
        int computed = binaryGap.computeByMySolution(561892);

        // Then
        Assert.assertEquals(3, computed);
    }

    @Test
    public void compute_2147483647_max() throws Exception {
        // Given
        BinaryGap binaryGap = new BinaryGap();
        log.info(Integer.toBinaryString(2147483647));

        // When
        int computed = binaryGap.computeByMySolution(2147483647);

        // Then
        Assert.assertEquals(0, computed);
    }

    @Test
    public void compute_0_min() throws Exception {
        // Given
        BinaryGap binaryGap = new BinaryGap();
        log.info(Integer.toBinaryString(0));

        // When
        int computed = binaryGap.computeByMySolution(0);

        // Then
        Assert.assertEquals(0, computed);
    }

    @Test
    public void compute_1_min() throws Exception {
        // Given
        BinaryGap binaryGap = new BinaryGap();
        log.info(Integer.toBinaryString(0));

        // When
        int computed = binaryGap.computeByMySolution(0);

        // Then
        Assert.assertEquals(0, computed);
    }

    @Test
    public void compute_74901729_large() throws Exception {
        // Given
        BinaryGap binaryGap = new BinaryGap();
        log.info(Integer.toBinaryString(74901729));

        // When
        int computed = binaryGap.computeByMySolution(74901729);

        // Then
        Assert.assertEquals(4, computed);
    }
}
