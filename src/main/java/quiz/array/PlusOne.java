package quiz.array;

import java.util.Arrays;

/**
 * Given a non-empty array of decimal digits
 * representing a non-negative integer,
 * increment one to the integer.
 * <br/><br/>
 * The digits are stored such that
 * the most significant digit is at the head of the list,
 * and each element in the array contains a single digit.
 * <br/><br/>
 * You may assume the integer does not contain any leading zero,
 * except the number 0 itself.
 * <br/><br/>
 * constraints:<br/>
 * - 1 <= digits.length <= 100<br/>
 * - 0 <= digits[i] <= 9<br/>
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        final int[] plus = new int[digits.length + 1];
        System.arraycopy(digits, 0, plus, 1, digits.length);
        plus[digits.length] = digits[digits.length - 1] + 1;

        for (int i = plus.length - 1; i >= 0; i--) {
            if (plus[i] >= 10) {
                plus[i] = plus[i] % 10;
                plus[i - 1] += 1;
            }
        }

        if (plus[0] == 0) {
            return Arrays.copyOfRange(plus, 1, plus.length);
        }

        return plus;
    }

}
