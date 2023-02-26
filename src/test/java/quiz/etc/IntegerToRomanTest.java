package quiz.etc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanTest {

    private final IntegerToRoman solution = new IntegerToRoman();

    @Test
    void example1() {
        var num = 3;
        var expected = "III";
        var result = solution.intToRoman(num);
        assertEquals(expected, result);
    }

    @Test
    void example2() {
        var num = 58;
        var expected = "LVIII";
        var result = solution.intToRoman(num);
        assertEquals(expected, result);
    }

    @Test
    void example3() {
        var num = 1994;
        var expected = "MCMXCIV";
        var result = solution.intToRoman(num);
        assertEquals(expected, result);
    }

    @Test
    void custom1() {
        assertEquals("I", solution.intToRoman(1));
        assertEquals("II", solution.intToRoman(2));
        assertEquals("III", solution.intToRoman(3));
        assertEquals("IV", solution.intToRoman(4));
        assertEquals("V", solution.intToRoman(5));
        assertEquals("VI", solution.intToRoman(6));
        assertEquals("VII", solution.intToRoman(7));
        assertEquals("VIII", solution.intToRoman(8));
        assertEquals("IX", solution.intToRoman(9));
        assertEquals("X", solution.intToRoman(10));
        assertEquals("XI", solution.intToRoman(11));
        assertEquals("XII", solution.intToRoman(12));
        assertEquals("XIII", solution.intToRoman(13));
        assertEquals("XIV", solution.intToRoman(14));
    }

    @Test
    void custom2() {
        assertEquals("IV", solution.intToRoman(4)); // IIII
        assertEquals("IX", solution.intToRoman(9)); // VIIII
        assertEquals("XL", solution.intToRoman(40)); // XXXX
        assertEquals("XC", solution.intToRoman(90)); // LXXXX
        assertEquals("CD", solution.intToRoman(400)); // CCCC
        assertEquals("CM", solution.intToRoman(900)); // DCCCC
    }

}