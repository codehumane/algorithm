package quiz.array;

import java.util.*;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */
public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        var solution1 = new IterateSOnlyOnce().numMatchingSubseq(s, words);
        var solution2 = new MatchingWordUniquely().numMatchingSubseq(s, words);
        assert solution1 == solution2;
        return solution1;
    }

    static class IterateSOnlyOnce {

        public int numMatchingSubseq(String s, String[] words) {
            var heads = toHeads(words);
            return matchByHeader(s, heads);
        }

        private Map<Character, List<Word>> toHeads(String[] words) {
            var heads = new HashMap<Character, List<Word>>();

            for (String word : words) {
                var w = new Word(word);
                heads.putIfAbsent(w.header(), new ArrayList<>());
                heads.get(w.header()).add(w);
            }

            return heads;
        }

        private int matchByHeader(String s, Map<Character, List<Word>> heads) {
            var count = 0;

            for (var c : s.toCharArray()) {
                if (!heads.containsKey(c)) continue;

                var old = heads.get(c);
                heads.put(c, new ArrayList<>());

                for (Word o : old) {
                    o.increase();

                    if (o.isEnd()) {
                        count++;
                        continue;
                    }

                    heads.putIfAbsent(o.header(), new ArrayList<>());
                    heads.get(o.header()).add(o);
                }

                old.clear();
            }

            return count;
        }

        static class Word {

            final String value;
            int head;

            Word(String value) {
                this.value = value;
                this.head = 0;
            }

            Character header() {
                return isEnd() ? null : value.charAt(head);
            }

            boolean isEnd() {
                return head == value.length();
            }

            void increase() {
                head++;
            }
        }
    }

    static class MatchingWordUniquely {
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

}
