package quiz.string;

import java.util.Arrays;

/**
 * Write a function that reverses a string.
 * The input string is given as an array of characters s.<br/>
 * <br/>
 * https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/
 */
public class ReverseString {

    public void reverseString(char[] s) {
        final char[] copy1 = Arrays.copyOf(s, s.length);
        final char[] copy2 = Arrays.copyOf(s, s.length);

        byIterationWithTwoPointers(s);
        byIterationWithoutTwoPointers(copy1);
        byRecursive(copy2);

        if (!Arrays.equals(s, copy1) || !Arrays.equals(s, copy2)) {
            throw new IllegalStateException();
        }
    }

    private void byRecursive(char[] s) {
        byRecursive(s, 0, s.length - 1);
    }

    private void byRecursive(char[] s, int left, int right) {
        if (left >= right) return;

        swap(s, left, right);
        byRecursive(s, ++left, --right);
    }

    private void byIterationWithoutTwoPointers(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            swap(s, i, s.length - 1 - i);
        }
    }

    private void byIterationWithTwoPointers(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            swap(s, left++, right--);
        }
    }

    private void swap(char[] s, int i1, int i2) {
        final char temp = s[i1];
        s[i1] = s[i2];
        s[i2] = temp;
    }

}
