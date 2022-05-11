package quiz.math;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        var cached = new HashSet<Integer>();
        var number = n;

        do {
            cached.add(number);
            number = replace(number);
            if (number == 1) return true;
        } while (!cached.contains(number));

        return false;
    }

    private int replace(int number) {
        var string = String.valueOf(number);
        var result = 0;

        for (int i = 0; i < string.length(); i++) {
            var digit = Integer.parseInt(string.substring(i, i + 1));
            result += Math.pow(digit, 2);
        }

        return result;
    }

}
