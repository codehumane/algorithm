package quiz.dynamic;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * <p>
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
public class RegularExpressionMatching {

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();

        var firstMatch = !text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

}
