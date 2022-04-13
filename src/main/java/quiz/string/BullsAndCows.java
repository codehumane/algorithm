package quiz.string;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 */
@Slf4j
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        var counts = countSecretChars(secret);
        var bulls = collectBulls(secret, guess, counts);
        var cows = collectCows(guess, counts, bulls);

        return String.format("%dA%dB", bulls.size(), cows.size());
    }

    private HashMap<Character, Integer> countSecretChars(String secret) {
        var counts = new HashMap<Character, Integer>();

        for (int i = 0; i < secret.length(); i++) {
            var c = secret.charAt(i);
            counts.putIfAbsent(c, 0);
            counts.computeIfPresent(c, (k, v) -> v + 1);
        }

        return counts;
    }

    private Map<Integer, Character> collectBulls(String secret,
                                                 String guess,
                                                 Map<Character, Integer> counts) {

        var bulls = new HashMap<Integer, Character>();

        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                var c = secret.charAt(i);
                counts.computeIfPresent(c, (k, v) -> v - 1);
                bulls.put(i, c);
            }
        }

        return bulls;
    }

    private HashMap<Integer, Character> collectCows(String guess,
                                                    Map<Character, Integer> counts,
                                                    Map<Integer, Character> bulls) {

        var cows = new HashMap<Integer, Character>();

        for (int i = 0; i < guess.length(); i++) {
            if (bulls.containsKey(i)) continue;

            var ch = guess.charAt(i);
            var count = counts.getOrDefault(ch, 0);

            if (count > 0) {
                cows.put(i, ch);
                counts.computeIfPresent(ch, (k, v) -> v - 1);
            }
        }

        return cows;
    }

}
