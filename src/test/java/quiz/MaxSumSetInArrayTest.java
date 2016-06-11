package quiz;

import junit.framework.Assert;
import org.junit.Test;

public class MaxSumSetInArrayTest {

    @Test
    public void sum_배열_길이가_1인_경우() {
        // Given
        MaxSumSetInArray summer = new MaxSumSetInArray();
        int[] array = {3};

        // When
        int sum = summer.sum(array);

        // Then
        Assert.assertEquals(3, sum);
    }

    @Test
    public void sum_1과_마이너스_1이_있는_경우_연속된_부분_구간중_최대합은_1하나로_이루어진_구간의_합인_1이다() throws Exception {
        // Given
        MaxSumSetInArray summer = new MaxSumSetInArray();
        int[] array = {1, -1};

        // When
        int sum = summer.sum(array);

        // Then
        Assert.assertEquals(1, sum);
    }

    @Test
    public void sum_1과_2_그리고_마이너스_1이_있는_경우_연속된_부분_구간중_최대합은_1과_2로_이루어진_구간의_합인_3이다() throws Exception {
        // Given
        MaxSumSetInArray summer = new MaxSumSetInArray();
        int[] array = {1, 2, -1};

        // When
        int sum = summer.sum(array);

        // Then
        Assert.assertEquals(3, sum);
    }
}
