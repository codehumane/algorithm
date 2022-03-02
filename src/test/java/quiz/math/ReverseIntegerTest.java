package quiz.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class ReverseIntegerTest {
    @ParameterizedTest
    @CsvSource({

            // example
            "  123 ,  321 ",
            " -123 , -321 ",
            "  120 ,  21  ",

            // custom
            "    1 ,  1   ",
            "    0 ,  0   ",
            "   -1 , -1   ",

            // out of range
            "  1563847412, 0 ",
            " -1563847412, 0 "

    })
    void reverse(int input, int output) {
        assertEquals(output, new ReverseInteger().reverse(input));
    }
}