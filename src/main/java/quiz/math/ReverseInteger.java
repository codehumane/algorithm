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
        var number = String.valueOf(x);
        var reversed = new StringBuilder();
        var padRemoval = true;

        if (number.startsWith("-")) {
            number = number.substring(1);
            reversed.append("-");
        }

        for (int i = number.length() - 1; i >= 0; i--) {
            if (padRemoval) {
                if (number.charAt(i) == '0') {
                    continue;
                } else {
                    padRemoval = false;
                }
            }
            reversed.append(number.charAt(i));
        }

        try {
            return Integer.parseInt(reversed.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
