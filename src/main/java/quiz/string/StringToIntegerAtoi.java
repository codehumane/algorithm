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
        var digitNumbers = new ArrayList<Integer>(s.length());
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

            digitNumbers.add(Integer.parseInt(String.valueOf(c)));
        }

        var number = 0;
        for (int digitNum : digitNumbers) {

            if (Integer.MAX_VALUE / 10 < number || Integer.MAX_VALUE / 10 == number && Integer.MAX_VALUE % 10 < digitNum) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            number = number * 10 + digitNum;
        }

        return number * sign;
    }

}
