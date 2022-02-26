package quiz.dynamic;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/word-break/
 * <p>
 * TODO 일단 recursion으로 구현 후 loop로 개선
 */
@Slf4j
public class WordBreak {

    public boolean wordBreak(String text, List<String> dictionary) {
        var dp = new DynamicProgramming().wordBreak(text, dictionary);
        var recursion = new Recursion().wordBreak(text, dictionary);
        var simple = new SimpleAndEfficient().wordBreak(text, dictionary);

        assert dp == recursion;
        assert dp == simple;

        return dp;
    }

    /**
     * 출처: https://www.programcreek.com/2012/12/leetcode-solution-word-break/
     */
    static class SimpleAndEfficient {
        boolean wordBreak(String text, List<String> dictionary) {
            var dict = new HashSet<>(dictionary);
            var pos = new int[text.length() + 1];
            Arrays.fill(pos, -1);
            pos[0] = 0;

            for (int from = 0; from < text.length(); from++) {
                if (pos[from] == -1) continue;

                for (int to = from + 1; to <= text.length(); to++) {
                    var sub = text.substring(from, to);
                    if (dict.contains(sub)) {
                        pos[to] = from;
                    }
                }
            }

            return pos[text.length()] != -1;
        }
    }

    static class DynamicProgramming {
        boolean wordBreak(String text, List<String> dictionary) {
            var cache = new boolean[text.length()];

            for (int i = 0; i < text.length(); i++) {
                for (String segment : dictionary) {
                    var endIdx = i + segment.length() - 1;

                    if (endIdx >= text.length()) continue;
                    if (i > 0 && !cache[i - 1]) continue;
                    if (cache[endIdx]) continue;

                    cache[endIdx] = text
                            .substring(i, endIdx + 1)
                            .equals(segment);
                }
            }

            return cache[text.length() - 1];
        }
    }

    static class Recursion {
        boolean wordBreak(String text, List<String> dictionary) {

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
}
