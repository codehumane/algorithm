package quiz.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInRotatedSortedArrayTest {

    private final SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

    @Test
    void example1() {

        // given
        var nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        var target = 0;
        var expected = 4;

        // when
        var result = solution.search(nums, target);

        // then
        assertEquals(expected, result);
    }

    @Test
    void example2() {

        // given
        var nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        var target = 3;
        var expected = -1;

        // when
        var result = solution.search(nums, target);

        // then
        assertEquals(expected, result);
    }

    @Test
    void example3() {

        // given
        var nums = new int[]{1};
        var target = 0;
        var expected = -1;

        // when
        var result = solution.search(nums, target);

        // then
        assertEquals(expected, result);
    }

    @Test
    void custom1() {

        // given
        var nums = new int[]{1, 4, 5, 6};
        var target = 2;
        var expected = -1;

        // when
        var result = solution.search(nums, target);

        // then
        assertEquals(expected, result);
    }

    @Test
    void custom2() {

        // given
        var nums = new int[]{1, 4, 5, 6};
        var target = 5;
        var expected = 2;

        // when
        var result = solution.search(nums, target);

        // then
        assertEquals(expected, result);
    }

}