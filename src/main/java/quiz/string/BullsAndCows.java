package quiz.string;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 */
@Slf4j
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        var counts = countChars(secret);
        var bulls = countBulls(secret, guess, counts);
        var cows = countCows(secret, guess, counts);
        return String.format("%dA%dB", bulls, cows);
    }

    private Map<Character, Long> countChars(String secret) {

        return secret
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    private int countBulls(String secret,
                           String guess,
                           Map<Character, Long> counts) {

        var count = 0;
        for (int i = 0; i < secret.length(); i++) {
            var c = guess.charAt(i);

            if (c == secret.charAt(i) && counts.get(c) > 0) {
                counts.put(c, counts.get(c) - 1);
                count++;
            }
        }

        return count;
    }

    private int countCows(String secret,
                          String guess,
                          Map<Character, Long> counts) {

        var count = 0;
        for (int i = 0; i < secret.length(); i++) {
            var c = guess.charAt(i);

            if (c != secret.charAt(i) && counts.getOrDefault(c, 0L) > 0) {
                counts.put(c, counts.get(c) - 1);
                count++;
            }
        }

        return count;
    }

}
