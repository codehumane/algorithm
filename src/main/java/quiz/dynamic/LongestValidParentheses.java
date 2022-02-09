package quiz.dynamic;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        var index = s.indexOf("()");
        var max = 0;

        while (index >= 0) {
            var left = index;
            var right = index + 1;

            while (true) {
                if (isRightExpanding(s, right)) {
                    right += 2;
                } else if (isSurroundExpanding(s, left, right)) {
                    left -= 1;
                    right += 1;
                } else {
                    index = s.indexOf("()", right + 1);
                    max = Math.max(max, right - left + 1);
                    break;
                }
            }
        }

        return max;
    }

    private boolean isRightExpanding(String s, int rightIdx) {
        return rightIdx + 2 < s.length()
                && s.charAt(rightIdx + 1) == '('
                && s.charAt(rightIdx + 2) == ')';
    }

    private boolean isSurroundExpanding(String s, int leftIdx, int rightIdx) {
        return 0 < leftIdx
                && rightIdx + 1 < s.length()
                && s.charAt(leftIdx - 1) == '('
                && s.charAt(rightIdx + 1) == ')';
    }

}
