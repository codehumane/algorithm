package quiz.dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubsequenceTest {

    private final LongestCommonSubsequence solution = new LongestCommonSubsequence();

    @Test
    public void example1() {

        // given
        var text1 = "abcde";
        var text2 = "ace";
        var output = 3;

        // when
        var result = solution.longestCommonSubsequence(text1, text2);

        // then
        assertEquals(output, result);
    }

    @Test
    public void example2() {

        // given
        var text1 = "abc";
        var text2 = "abc";
        var output = 3;

        // when
        var result = solution.longestCommonSubsequence(text1, text2);

        // then
        assertEquals(output, result);
    }

    @Test
    public void example3() {

        // given
        var text1 = "abc";
        var text2 = "def";
        var output = 0;

        // when
        var result = solution.longestCommonSubsequence(text1, text2);

        // then
        assertEquals(output, result);
    }

    @Test
    public void custom1_text1_길이가_1인_경우() {

        // given
        var text1 = "a";
        var text2 = "aabaa";
        var output = 1;

        // when
        var result = solution.longestCommonSubsequence(text1, text2);

        // then
        assertEquals(output, result);
    }

    @Test
    public void custom2_text1_길이가_2인_경우() {

        // given
        var text1 = "ab";
        var text2 = "aabaa";
        var output = 2;

        // when
        var result = solution.longestCommonSubsequence(text1, text2);

        // then
        assertEquals(output, result);
    }

}