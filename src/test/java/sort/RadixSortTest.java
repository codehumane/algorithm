package sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class RadixSortTest {

    @Test
    void example() {

        // given
        int[] target = {256, 336, 736, 443, 831, 907};
        int[] expected = {256, 336, 443, 736, 831, 907};
        var radix = new RadixSort();

        // when
        radix.sort(target);

        // then
        assertArrayEquals(expected, target);
    }
    
}