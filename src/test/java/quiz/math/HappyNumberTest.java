package quiz.math;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {

    private final HappyNumber solution = new HappyNumber();

    @ParameterizedTest
    @CsvSource({
            "19,true",
            "2,false"
    })
    void name(int n, boolean result) {
        assertEquals(result, solution.isHappy(n));
    }

}