package quiz.dynamic;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        return new Wrong().longestValidParentheses(s);
    }

    /**
     * isLeftConcatenating 케이스를 생각 못했는데,
     * 단편적으로 한 번만 왼쪽 결과를 더하는 것뿐만 아니라,
     * 여러 번 더하는 경우까지 고려해야 하는데,
     * 그러지 못하는 문제가 있음.
     * 그러려면 공간복잡도가 올라감.
     * 결국 이 방식은 오류!
     */
    static class Wrong {
        public int longestValidParentheses(String s) {
            var index = s.indexOf("()");
            var lastLeft = -1;
            var lastRight = -1;
            var max = 0;

            while (index >= 0) {
                var l = index;
                var r = index + 1;

                while (true) {
                    if (isRightExpanding(s, r)) {
                        r += 2;
                    } else if (isSurroundExpanding(s, l, r)) {
                        l -= 1;
                        r += 1;
                    } else if (isLeftConcatenating(lastLeft, lastRight, l)) {
                        l = lastLeft;
                    } else {
                        var length = r - l + 1;
                        max = Math.max(max, length);
                        index = s.indexOf("()", r + 1);
                        lastLeft = l;
                        lastRight = r;
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

        private boolean isLeftConcatenating(int lastLeft, int lastRight, int leftIndex) {
            return 0 <= lastLeft
                    && lastRight + 1 == leftIndex;
        }
    }

}
