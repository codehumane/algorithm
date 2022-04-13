package quiz.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsTest {

    private final BullsAndCows solution = new BullsAndCows();

    @ParameterizedTest
    @CsvSource({
            "1807, 7810, 1A3B",
            "1123, 0111, 1A1B"
    })
    void examples(String secret, String guess, String output) {
        assertEquals(output, solution.getHint(secret, guess));
    }

}
