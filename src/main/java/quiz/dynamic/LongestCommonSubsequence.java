package quiz.dynamic;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    /**
     * \ a b c d e
     * a 1 1 1 1 1
     * c 0 1 2 2 2
     * e 0 0 1 2 3
     *
     * \ a c e
     * a 1 1 1
     * b 1 1 1
     * c 1 2 2
     * d 1 2 2
     * e 1 2 3
     */
    public int longestCommonSubsequence(String text1, String text2) {
        final int rows = text1.length();
        final int cols = text2.length();
        final int[][] common = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                final int up = (r > 0) ? common[r - 1][c] : 0;
                final int left = (c > 0) ? common[r][c - 1] : 0;
                final int upLeft = (r > 0 && c > 0) ? common[r - 1][c - 1] : 0;

                if (text1.charAt(r) == text2.charAt(c)) {
                    common[r][c] = upLeft + 1;
                } else {
                    common[r][c] = Math.max(up, left);
                }
            }
        }

        return common[rows - 1][cols - 1];
    }

}
