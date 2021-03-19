package quiz.string;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.<br/>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
 */
public interface LongestCommonPrefix {

    String longestCommonPrefix(String[] strs);

    class CompositeLongestCommonPrefix implements LongestCommonPrefix {

        private final List<LongestCommonPrefix> solutions = Arrays.asList(
                new VerticalScanningLongestCommonPrefix()
        );

        @Override
        public String longestCommonPrefix(String[] strs) {

            final Set<String> results = solutions
                    .stream()
                    .map(s -> s.longestCommonPrefix(strs))
                    .collect(Collectors.toSet());

            if (results.size() != 1) {
                throw new IllegalStateException();
            }

            return results
                    .iterator()
                    .next();
        }
    }

    class VerticalScanningLongestCommonPrefix implements LongestCommonPrefix {

        @Override
        public String longestCommonPrefix(String[] strs) {
            final StringBuilder builder = new StringBuilder();

            for (int i = 0; i < minLength(strs); i++) {
                if (!hasCommonCharAt(strs, i)) break;
                builder.append(strs[0].charAt(i));
            }

            return builder.toString();
        }

        private int minLength(String[] strs) {

            return Arrays
                    .stream(strs)
                    .mapToInt(String::length)
                    .min()
                    .orElse(0);
        }

        private boolean hasCommonCharAt(String[] strs, int index) {
            final char compare = strs[0].charAt(index);

            return Arrays
                    .stream(strs)
                    .allMatch(s -> s.charAt(index) == compare);
        }

    }
}
