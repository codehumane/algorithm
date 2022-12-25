package quiz.string;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
@Slf4j
public class StringToIntegerAtoi {

    public int myAtoi(String s) {

        var sign = 1;
        var started = false;
        var numbers = new ArrayList<Character>(s.length());
        for (char c : s.toCharArray()) {

            if (!started) {
                if (c == ' ') continue;

                started = true;

                if (c == '+') continue;
                if (c == '-') {
                    sign = -1;
                    continue;
                }
            }

            if (!Character.isDigit(c)) {
                break;
            }

            numbers.add(c);
        }

        var result = 0;
        for (Character n : numbers) {
            var digitNum = Integer.parseInt(String.valueOf(n));

            if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digitNum) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digitNum;
        }

        return result * sign;
    }

}
