package quiz.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class JumpGameTest {

    private JumpGame jumpGame = new JumpGame();

    @ParameterizedTest
    @CsvSource(value = {
            "'2,3,1,1,4', true",
            "'3,2,1,0,4', false"
    })
    void example(String n, String e) {
        assertEquals(
                Boolean.valueOf(e),
                jumpGame.canJump(toNums(n))
        );
    }

    @ParameterizedTest
    @CsvSource({
            "'0', true",
            "'1', true",
            "'1,0', true",
            "'0,1', false",
            "'0,1,0', false",
            "'1,0,0', false",
            "'2,0,0', true",
            "'3,0,0', true",
            "'1,1,0', true",
            "'2,1,0', true",
            "'2,2,0', true"
    })
    void custom(String n, String e) {
        assertEquals(
                Boolean.valueOf(e),
                jumpGame.canJump(toNums(n))
        );
    }

    @ParameterizedTest
    @CsvSource({
            "'3,0,8,2,0,0,1', true",
    })
    void wrong(String n, String e) {
        assertEquals(
                Boolean.valueOf(e),
                jumpGame.canJump(toNums(n))
        );
    }

    private int[] toNums(String source) {
        return Arrays
                .stream(source.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}