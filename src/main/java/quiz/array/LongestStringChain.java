package quiz.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-string-chain/
 */
public class LongestStringChain {

    // TODO SortedMap
    public int longestStrChain(String[] words) {

        var max = 1;
        var wordsDepth = new HashMap<String, Integer>(); // word depth

        for (String word : words) {
            var depth = dfs(word, words, wordsDepth);
            max = Math.max(max, depth);
        }

        return max;
    }

    private int dfs(String word,
                    String[] words,
                    Map<String, Integer> wordDepth) {

        if (wordDepth.containsKey(word)) {
            return wordDepth.get(word);
        }

        var maxDepth = 0;
        for (String w : words) {
            if (isPredecessor(word, w)) {
                maxDepth = Math.max(maxDepth, dfs(w, words, wordDepth));
            }
        }

        wordDepth.put(word, maxDepth + 1);
        return maxDepth + 1;
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
