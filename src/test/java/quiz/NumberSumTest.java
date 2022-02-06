package quiz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSumTest {

    @Test
    public void sum_기저사례인_1이_주어진_경우_1_하나의_합인_1을_반환한다() throws Exception {
        // Given
        NumberSum sum = new NumberSum();

        // When
        int result = sum.sum(1);

        // Then
        Assertions.assertEquals(1, result);
    }

    @Test
    public void sum_5가_주어진_경우_1부터_5까지를_모두_더한_15를_반환한다() throws Exception {
        // Given
        NumberSum sum = new NumberSum();

        // When
        int result = sum.sum(5);

        // Then
        Assertions.assertEquals(15, result);
    }

    @Test
    public void sum_11이_주어진_경우_47을_반환한다() throws Exception {
        // Given
        NumberSum sum = new NumberSum();

        // When
        int result = sum.sum(11);

        // Then
        Assertions.assertEquals(66, result);
    }
}
