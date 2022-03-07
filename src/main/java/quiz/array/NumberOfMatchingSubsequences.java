package quiz.array;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */
public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        var subsequences = new HashMap<String, Integer>();

        for (String w : words) {
            if (subsequences.containsKey(w)) {
                subsequences.computeIfPresent(w, (x, c) -> c + 1);
            } else if (isSubsequence(s, w)) {
                subsequences.put(w, 1);
            }
        }

        return subsequences
                .values()
                .stream()
                .mapToInt(v -> v)
                .sum();
    }

    boolean isSubsequence(String s, String w) {
        var si = 0;
        var wi = 0;

        while (si < s.length() && wi < w.length()) {
            if (s.charAt(si) == w.charAt(wi)) wi++;
            si++;
        }

        return wi == w.length();
    }

}
