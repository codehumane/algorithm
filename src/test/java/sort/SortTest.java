package sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
public class SortTest {

    private static Stream<Arguments> sorts() {
        return Stream.of(
                Arguments.of(new BubbleSort()),
                Arguments.of(new SelectionSort()),
                Arguments.of(new InsertionSort()),
                Arguments.of(new ParallelMergeSort()),
                Arguments.of(new MergeSort()),
                Arguments.of(new QuickSort()),
                Arguments.of(new CountingSort()),
                Arguments.of(new CountingSort2022()),
                Arguments.of(new RadixSort())
        );
    }

    @ParameterizedTest
    @MethodSource("sorts")
    public void sort_숫자가_하나만_주어진_경우_그대로_반환(Sort sort) throws Exception {
        // Given
        int[] list = {3};

        // When
        sort.sort(list);

        // Then
        int[] expected = {3};
        assertArrayEquals(expected, list);
    }

    @ParameterizedTest
    @MethodSource("sorts")
    public void sort_역순으로_주어진_경우_정렬해서_반환(Sort sort) throws Exception {
        // Given
        int[] list = {3, 2, 1};

        // When
        sort.sort(list);

        // Then
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, list);
    }

    @ParameterizedTest
    @MethodSource("sorts")
    public void sort_이미_정렬된_경우_그대로_반환(Sort sort) throws Exception {
        // Given
        int[] list = {1, 2, 3};

        // When
        sort.sort(list);

        // Then
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, list);
    }

    @ParameterizedTest
    @MethodSource("sorts")
    public void sort_순서_뒤죽박죽인_긴_배열(Sort sort) throws Exception {
        // Given
        int[] list = {3, 1, 5, 8, 7, 6, 2, 4};

        // When
        sort.sort(list);

        // Then
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, list);
    }

    @ParameterizedTest
    @MethodSource("sorts")
    public void sort_큰_배열(Sort sort) throws Exception {
//        sort.sort(bigList);
    }

    @ParameterizedTest
    @MethodSource("sorts")
    public void caseOfGeeksForGeeks(Sort sort) {
        // Given
        int[] list = {12, 11, 13, 5, 6, 7};

        // When
        sort.sort(list);

        // Then
        int[] expected = {5, 6, 7, 11, 12, 13};
        assertArrayEquals(expected, list);
    }
}
