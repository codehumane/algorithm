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
        var counts = countSecretChars(secret);
        var hint = toHint(secret, guess, counts);
        return hint.toString();
    }

    private Map<Character, Long> countSecretChars(String secret) {

        return secret
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    private Hint toHint(String secret,
                        String guess,
                        Map<Character, Long> counts) {

        var hint = new Hint();

        for (int i = 0; i < guess.length(); i++) {
            var gc = guess.charAt(i);
            if (counts.containsKey(gc)) {

                if (gc == secret.charAt(i)) {
                    hint.bulls++;

                    // 앞에서 bulls만 있었던 경우는 counts의 특성상 0보다 작을 수 없고,
                    // 따라서 0보다 작은 것은 cows가 있었던 경우에 한하며,
                    // bulls가 우선하므로,
                    // cows를 감소.
                    if (counts.get(gc) <= 0) {
                        hint.cows--;
                    }
                } else {

                    // bulls가 우선이므로,
                    // bulls에 이미 다 카운팅한 경우라면,
                    // cows 계산은 생략.
                    if (counts.get(gc) > 0) {
                        hint.cows++;
                    }
                }

                counts.put(gc, counts.get(gc) - 1);
            }
        }

        return hint;
    }

    static class Hint {

        int bulls = 0;
        int cows = 0;

        @Override
        public String toString() {
            return String.format("%dA%dB", bulls, cows);
        }
    }

}
