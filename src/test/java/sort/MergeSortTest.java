package sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
public class MergeSortTest {

    @ParameterizedTest
    @MethodSource("getSorter")
    public void sort(Sort sort) throws Exception {

        // given
        final int[] list = generateRandomInts();
        final int[] expected = Arrays.copyOf(list, list.length);
        Arrays.sort(expected);

        // when
        sort.sort(list);

        // then
        assertArrayEquals(expected, list);
    }

    private static Stream<Arguments> getSorter() {
        return Stream.of(
                Arguments.of(new ParallelMergeSort()),
                Arguments.of(new MergeSort())
        );
    }

    private int[] generateRandomInts() {
        final int[] list = new int[10000];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Random().nextInt(10000);
        }
        return list;
    }

}