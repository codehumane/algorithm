package quiz.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringToIntegerAtoiTest {

    private final StringToIntegerAtoi solution = new StringToIntegerAtoi();

    @Test
    void examples() {
        assertEquals(42, solution.myAtoi("42"));
        assertEquals(-42, solution.myAtoi("-42"));
        assertEquals(4193, solution.myAtoi("4193"));
    }

    @Test
    void customs() {
        assertEquals(-42, solution.myAtoi("   -42 "));
        assertEquals(42, solution.myAtoi("   +42 "));
        assertEquals(42, solution.myAtoi("   42 "));
        assertEquals(0, solution.myAtoi("    "));
        assertEquals(0, solution.myAtoi(" - 1  "));
        assertEquals(0, solution.myAtoi(" + 2 "));
        assertEquals(0, solution.myAtoi(" +  "));
    }

    @Test
    void clamp() {
        assertEquals(2147483646, solution.myAtoi("2147483646"));
        assertEquals(2147483647, solution.myAtoi("2147483647"));
        assertEquals(2147483647, solution.myAtoi("2147483648"));
        assertEquals(2147483647, solution.myAtoi("2147483649"));
        assertEquals(2147483647, solution.myAtoi("2147483650"));
        assertEquals(-2147483647, solution.myAtoi("-2147483647"));
        assertEquals(-2147483648, solution.myAtoi("-2147483648"));
        assertEquals(-2147483648, solution.myAtoi("-2147483649"));
        assertEquals(-2147483648, solution.myAtoi("-2147483650"));
    }

    @Test
    void wrong() {
        assertEquals(0, solution.myAtoi("words and 987"));
    }

}
