package quiz.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumPointsYouCanObtainFromCardsTest {

    private final MaximumPointsYouCanObtainFromCards solution = new MaximumPointsYouCanObtainFromCards();

    @ParameterizedTest
    @CsvSource(value = {
            " 1,2,3,4,5,6,1 | 3 | 12 ",
            " 2,2,2         | 2 | 4  ",
            " 9,7,7,9,7,7,9 | 7 | 55  ",
            " 1,79,80,1,1,1,200,1 | 3 | 202 ",
    }, delimiter = '|')
    void examples(String points, int k, int output) {
        var result = solution.maxScore(toIntArray(points), k);
        assertEquals(output, result);
    }

    private int[] toIntArray(String points) {
        return Arrays
                .stream(points.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
