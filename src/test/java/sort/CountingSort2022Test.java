package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountingSort2022Test {

    @Test
    void sort() {
        var input = new int[]{5, 4, 5, 5, 1, 1, 3};
        var expected = new int[]{1, 1, 3, 4, 5, 5, 5};
        new CountingSort2022().sort(input);
        assertArrayEquals(expected, input);
    }

}