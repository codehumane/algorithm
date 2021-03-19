package quiz.string;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.<br/>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        final StringBuilder builder = new StringBuilder();

        final int minLength = Arrays
                .stream(strs)
                .mapToInt(String::length)
                .min()
                .orElse(0);

        for (int i = 0; i < minLength; i++) {
            if (!hasCommonCharAt(strs, i)) break;
            builder.append(strs[0].charAt(i));
        }

        return builder.toString();
    }

    private boolean hasCommonCharAt(String[] strs, int i) {
        final char compare = strs[0].charAt(i);

        return Arrays
                .stream(strs)
                .allMatch(s -> s.charAt(i) == compare);
    }

}
