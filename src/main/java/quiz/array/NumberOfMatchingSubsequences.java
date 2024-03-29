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

            for (char c = 'a'; c <= 'z'; c++) {
                heads.put(c, new ArrayList<>());
            }

            for (String word : words) {
                var w = new Word(word);
                heads.get(w.header()).add(w);
            }

            return heads;
        }

        private int matchByHeader(String s, Map<Character, List<Word>> heads) {
            var count = 0;

            for (var c : s.toCharArray()) {

                var old = heads.get(c);
                heads.put(c, new ArrayList<>());

                for (Word o : old) {
                    o.increase();

                    if (o.isEnd()) {
                        count++;
                    } else {
                        heads.get(o.header()).add(o);
                    }
                }
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
                if (head < 0 || head >= value.length()) {
                    throw new IllegalStateException();
                }

                return value.charAt(head);
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
