package quiz.dynamic;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/
 * <p>
 * TODO 일단 recursion으로 구현 후 loop로 개선
 */
@Slf4j
public class WordBreak {

    public boolean wordBreak(String text, List<String> dictionary) {

        var concatSize = 0;
        var indices = toIndices(text, dictionary);

        if (indices.containsKey(0)) {
            for (String start : indices.get(0)) {
                if (match(text, start, concatSize, indices)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean match(String text,
                          String segment,
                          int concatSize,
                          Map<Integer, Set<String>> indices) {

        var nextIdx = concatSize + segment.length();
        if (nextIdx == text.length()) return true;
        if (!indices.containsKey(nextIdx)) return false;

        for (String next : indices.get(nextIdx)) {
            if (match(text, next, nextIdx, indices)) {
                return true;
            }
        }

        return false;
    }

    private Map<Integer, Set<String>> toIndices(String text, List<String> dictionary) {
        var indices = new HashMap<Integer, Set<String>>();

        for (String word : dictionary) {

            int from = 0;
            while (true) {
                var index = text.indexOf(word, from);
                if (index < 0) break;

                indices.putIfAbsent(index, new HashSet<>());
                indices.get(index).add(word);
                from = index + 1;
            }
        }

        return indices;
    }

}
