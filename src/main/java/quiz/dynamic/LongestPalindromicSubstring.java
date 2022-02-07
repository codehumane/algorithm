package quiz.dynamic;

import java.util.Objects;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        final var byDP = new ByDynamicProgramming().longestPalindrome(s);
        final var byAE = new ByAroundExpanding().longestPalindrome(s);
        assert Objects.equals(byDP, byAE);
        return byAE;
    }

    static class ByAroundExpanding {
        String longestPalindrome(String s) {

            var left = 0;
            var right = 0;

            for (int i = 0; i < s.toCharArray().length; i++) {

                var l = i;
                var r = i;

                while (r + 1 < s.length()
                        && s.charAt(r) == s.charAt(r + 1)) {
                    r++;
                }

                while (0 < l
                        && r + 1 < s.length()
                        && s.charAt(l - 1) == s.charAt(r + 1)) {
                    l--;
                    r++;
                }

                if (r - l > right - left) {
                    left = l;
                    right = r;
                }
            }

            return s.substring(left, right + 1);
        }
    }

    static class ByDynamicProgramming {
        String longestPalindrome(String s) {
            var tracking = new boolean[s.length()][s.length()];
            trackAllPalindrome(s, tracking);
            return getLongestPalindrome(s, tracking);
        }

        private void trackAllPalindrome(String s, boolean[][] tracking) {
            for (int i = 0; i < s.toCharArray().length; i++) {
                tracking[i][i] = true;

                var repeat = 0;
                while (i + repeat + 1 < s.length()
                        && s.charAt(i) == s.charAt(i + repeat + 1)) {

                    tracking[i][i + repeat + 1] = true;
                    repeat++;
                }

                var decalcomanie = 0;
                while (0 <= i - decalcomanie - 1
                        && i + repeat + decalcomanie + 1 < s.length()
                        && s.charAt(i - decalcomanie - 1) == s.charAt(i + repeat + decalcomanie + 1)) {

                    tracking[i - decalcomanie - 1][i + repeat + decalcomanie + 1] = true;
                    decalcomanie++;
                }
            }
        }

        private String getLongestPalindrome(String s, boolean[][] tracking) {
            var start = 0;
            var end = 0;

            for (boolean[] row : tracking) {
                int startCandidate = tracking.length - 1;
                int endCandidate = 0;

                for (int col = 0; col < tracking.length; col++) {
                    if (row[col]) {
                        startCandidate = Math.min(startCandidate, col);
                        endCandidate = Math.max(endCandidate, col);
                    }
                }

                if (end - start < endCandidate - startCandidate) {
                    start = startCandidate;
                    end = endCandidate;
                }
            }

            return s.substring(start, end + 1);
        }
    }

}
