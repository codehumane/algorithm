package quiz.math;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FourSumTest {

    private final FourSum solution = new FourSum();

    @Test
    void example1() {

        // given
        var nums = new int[]{1, 0, -1, 0, -2, 2};
        var target = 0;
        var expected = Set.of(
                List.of(-2, -1, 1, 2),
                List.of(-2, 0, 0, 2),
                List.of(-1, 0, 0, 1)
        );

        // when
        var result = solution.fourSum(nums, target);

        // then
        assertEquals(expected, new HashSet<>(result));
    }

    @Test
    void example2() {

        // given
        var nums = new int[]{2, 2, 2, 2, 2};
        var target = 8;
        var expected = Set.of(
                List.of(2, 2, 2, 2)
        );

        // when
        var result = solution.fourSum(nums, target);

        // then
        assertEquals(expected, new HashSet<>(result));
    }

    @Test
    void wrong1() {

        // given
        var nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        var target = -294967296;
        var expected = Set.of();

        // when
        var result = solution.fourSum(nums, target);

        // then
        assertEquals(expected, new HashSet<>(result));
    }

}