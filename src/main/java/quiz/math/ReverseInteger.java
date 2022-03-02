package quiz.math;

/**
 * https://leetcode.com/problems/reverse-integer/
 * <p>
 * Given a signed 32-bit integer x,
 * return x with its digits reversed.
 * <p>
 * If reversing x causes the value to go outside
 * the signed 32-bit integer range [-231, 231 - 1],
 * then return 0.
 */
public class ReverseInteger {

    public int reverse(int x) {
        var reversed = reverse(String.valueOf(x));
        reversed = processNegative(reversed);
        reversed = removeZeroPad(reversed);
        return parseInt(reversed);
    }

    private String reverse(String number) {
        var reversed = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            reversed.append(number.charAt(i));
        }

        return reversed.toString();
    }

    private String processNegative(String reversed) {
        if (reversed.endsWith("-")) {
            reversed = reversed.substring(0, reversed.length() - 1);
            reversed = "-" + reversed;
        }

        return reversed;
    }

    private String removeZeroPad(String reversed) {
        while (reversed.startsWith("0")) {
            reversed = reversed.substring(1);
        }

        return reversed;
    }

    private int parseInt(String reversed) {
        try {
            return Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
