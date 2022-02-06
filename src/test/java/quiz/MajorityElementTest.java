package quiz;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MajorityElementTest {

    private final MajorityElement solution = new MajorityElement();

    @Test
    public void example1() {

        // given
        val input = new int[]{3, 2, 3};
        val expected = 3;

        // when
        val result = solution.majorityElement(input);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void example2() {

        // given
        val input = new int[]{2, 2, 1, 1, 1, 2, 2};
        val expected = 2;

        // when
        val result = solution.majorityElement(input);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void custom1() {

        // given
        val input = new int[]{3, 7, 2, 2, 7, 7, 7};
        val expected = 7;

        // when
        val result = solution.majorityElement(input);

        // then
        assertEquals(expected, result);
    }

}