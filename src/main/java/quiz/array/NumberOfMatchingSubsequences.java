package quiz.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */
public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        var yes = new HashMap<String, Integer>();
        var no = new HashSet<String>();

        for (String w : words) {
            if (no.contains(w)) continue;

            if (yes.containsKey(w)) {
                yes.computeIfPresent(w, (x, c) -> c + 1);
            } else if (isSubsequence(s, w)) {
                yes.put(w, 1);
            } else {
                no.add(w);
            }
        }

        return yes
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
