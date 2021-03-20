package quiz.string;

/**
 * Write a function that reverses a string.
 * The input string is given as an array of characters s.<br/>
 * <br/>
 * https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/
 */
public class ReverseString {

    public void reverseString(char[] s) {
        final int mid = s.length / 2;
        for (int i = 0; i < mid; i++) {
            swap(s, i, s.length - 1 - i);
        }
    }

    private void swap(char[] s, int i1, int i2) {
        final char temp = s[i1];
        s[i1] = s[i2];
        s[i2] = temp;
    }

}
