package quiz.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BullsAndCowsTest {

    private final BullsAndCows solution = new BullsAndCows();

    @ParameterizedTest
    @CsvSource({
            "1807, 7810, 1A3B",
            "1123, 0111, 1A1B",

            // custom
            "0007, 7117, 1A0B" // bulls가 cows보다 우선함을 확인
    })
    void examples(String secret, String guess, String output) {
        assertEquals(output, solution.getHint(secret, guess));
    }

}
