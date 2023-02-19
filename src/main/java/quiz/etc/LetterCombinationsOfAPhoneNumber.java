package quiz.etc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LetterCombinationsOfAPhoneNumber {

    final Map<Character, Set<String>> mapping = Map.of(
            '1', Set.of(),
            '2', Set.of("a", "b", "c"),
            '3', Set.of("d", "e", "f"),
            '4', Set.of("g", "h", "i"),
            '5', Set.of("j", "k", "l"),
            '6', Set.of("m", "n", "o"),
            '7', Set.of("p", "q", "r", "s"),
            '8', Set.of("t", "u", "v"),
            '9', Set.of("w", "x", "y", "z")
    );

    public List<String> letterCombinations(String digits) {
        var capacity = combinationCapacity(digits);
        var combinations = new ArrayList<String>(capacity);

        if (capacity == 0) {
            return combinations;
        }

        combination(combinations, 0, capacity, "", digits, 0);
        return combinations;
    }

    private int combinationCapacity(String digits) {

        return digits
                .chars()
                .mapToObj(c -> (char) c)
                .mapToInt(c -> mapping.get(c).size())
                .filter(size -> size > 0)
                .reduce((l, r) -> l * r)
                .orElse(0);
    }

    private void combination(List<String> combinations,
                             int start, // inclusive
                             int end, // exclusive
                             String combination,
                             String digits,
                             int digitIndex) {

        if (digitIndex >= digits.length()) {
            combinations.add(combination);
            return;
        }

        if (digits.charAt(digitIndex) == '1') {
            combination(combinations, start, end, combination, digits, digitIndex + 1);
            return;
        }

        var chars = mapping.get(digits.charAt(digitIndex));
        var s = start;

        for (String c : chars) {
            var e = s + (end - start) / chars.size();
            combination(combinations, s, e, combination + c, digits, digitIndex + 1);
            s = e;
        }
    }

}
