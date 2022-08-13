package quiz.dynamic;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

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
        return new UsingStack().minRemoveToMakeValid(s);
    }

    static class UsingStack {

        public String minRemoveToMakeValid(String s) {
            return makeValid(s, collectInvalidIndices(s));
        }

        private Set<Integer> collectInvalidIndices(String s) {
            var invalids = new HashSet<Integer>();
            var opens = new ArrayDeque<Integer>();

            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i);

                if ('(' == c) {
                    opens.push(i);
                }

                if (')' == c) {
                    if (opens.isEmpty()) invalids.add(i);
                    else opens.pop();
                }
            }

            invalids.addAll(opens);
            return invalids;
        }

        private String makeValid(String s, Set<Integer> invalidIndices) {
            var builder = new StringBuilder(s.length());

            for (int i = 0; i < s.length(); i++) {
                if (!invalidIndices.contains(i)) {
                    builder.append(s.charAt(i));
                }
            }

            return builder.toString();
        }

    }

}
