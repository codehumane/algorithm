package quiz.dynamic;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-string-chain/
 */
public class LongestStringChain {

    public int longestStrChain(String[] words) {

        var max = 1;
        var cache = new HashMap<String, Integer>();
        var lengthToWords = lengthToWords(words);

        for (String word : words) {
            var depth = dfs(word, lengthToWords, cache);
            max = Math.max(max, depth);
        }

        return max;
    }

    private Map<Integer, Set<String>> lengthToWords(String[] words) {
        var lengths = new HashMap<Integer, Set<String>>();

        for (String word : words) {
            lengths.putIfAbsent(word.length(), new HashSet<>());
            lengths.get(word.length()).add(word);
        }

        return lengths;
    }

    private int dfs(String word,
                    Map<Integer, Set<String>> words,
                    Map<String, Integer> memoized) {

        if (memoized.containsKey(word)) {
            return memoized.get(word);
        }

        var candidates = words
                .getOrDefault(word.length() + 1, Collections.emptySet());

        var depth = 0;
        for (String candidate : candidates) {
            if (isPredecessor(word, candidate)) {
                depth = Math.max(depth, dfs(candidate, words, memoized));
            }
        }

        memoized.put(word, depth + 1);
        return depth + 1;
    }

    boolean isPredecessor(String before, String after) {
        if (before.length() + 1 != after.length()) return false;

        var bi = 0;
        var ai = 0;
        var inserted = false;

        while (bi < before.length() && ai < after.length()) {
            if (before.charAt(bi) != after.charAt(ai)) {
                if (inserted) return false;

                ai++;
                inserted = true;
                continue;
            }

            ai++;
            bi++;
        }

        return true;
    }

}
