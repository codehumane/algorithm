package quiz.dynamic;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * <p>
 * Given a string s of '(' , ')' and lowercase English characters.
 * <br/><br/>
 * Your task is to
 * remove the minimum number of parentheses ( '(' or ')', in any positions )
 * so that the resulting parentheses string is valid
 * and return any valid string.
 * <br/><br/>
 * Formally, a parentheses string is valid if and only if:
 * <br/><br/>
 * - It is the empty string, contains only lowercase characters, or<br/>
 * - It can be written as AB (A concatenated with B), where A and B are valid strings, or<br/>
 * - It can be written as (A), where A is a valid string.<br/>
 */
public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        var invalidIndices = collectInvalidCharIndices(s);
        return makeValid(s, invalidIndices);
    }

    private HashSet<Integer> collectInvalidCharIndices(String s) {
        var opens = new ArrayDeque<Integer>();
        var closes = new ArrayDeque<Integer>();

        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);

            if ('(' == c) {
                opens.push(i);
            }

            if (')' == c) {
                if (opens.isEmpty()) {
                    closes.push(i);
                } else {
                    opens.pop();
                }
            }
        }

        var indices = new HashSet<>(opens);
        indices.addAll(closes);
        return indices;
    }

    private String makeValid(String s, HashSet<Integer> invalidIndices) {
        var builder = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndices.contains(i)) {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }

}
