package quiz.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */
public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        return (int) Arrays
                .stream(words)
                .filter(w -> isSubsequence(s, w))
                .count();
    }

    boolean isSubsequence(String source, String target) {
        var si = 0;
        var ti = 0;

        while (si < source.length() && ti < target.length()) {
            if (source.charAt(si) == target.charAt(ti)) ti++;
            si++;
        }

        return ti == target.length();
    }

}
