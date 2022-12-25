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
        var collecting = false;
        var numbers = new ArrayList<Character>(s.length());

        for (char c : s.toCharArray()) {
            if (!collecting) {
                if (Character.isDigit(c)) numbers.add(c);
                else if (c == '-') sign = -1;
                else if (c != '+') continue;
                collecting = true;
            } else {
                if (Character.isDigit(c)) numbers.add(c);
                else break;
            }
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
