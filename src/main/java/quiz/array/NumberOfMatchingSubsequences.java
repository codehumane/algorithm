package quiz.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */
public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        var iterateSOnce = new IterateSOnlyOnce().numMatchingSubseq(s, words);
        var effectiveBruteForce = new MatchingWordUniquely().numMatchingSubseq(s, words);

        assert iterateSOnce == effectiveBruteForce;
        return iterateSOnce;
    }

    @Slf4j
    static class IterateSOnlyOnce {
        public int numMatchingSubseq(String s, String[] words) {

            var heads = Arrays
                    .stream(words)
                    .map(Word::new)
                    .collect(Collectors.toList());

            for (int i = 0; i < s.toCharArray().length; i++) {
                for (Word head : heads) {
                    if (!head.isEnd() && head.header() == s.charAt(i)) {
                        head.increase();
                    }
                }
            }

            return (int) heads
                    .stream()
                    .filter(Word::isEnd)
                    .count();
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
