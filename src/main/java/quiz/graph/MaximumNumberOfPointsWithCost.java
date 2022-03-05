package quiz.graph;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-number-of-points-with-cost/
 */
public class MaximumNumberOfPointsWithCost {

    public long maxPoints(int[][] points) {

        var row = points.length;
        var col = points[0].length;
        var max = new long[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {

                var point = points[r][c];

                // 첫 번째 로우
                if (r == 0) {
                    max[r][c] = point;
                    continue;
                }

                var upMax = max[r - 1][c];

                // 가운데 값
                max[r][c] = Math.max(
                        upMax + point,
                        max[r][c]
                );

                // 왼쪽 값들
                var lc = c - 1;
                while (lc >= 0) {
                    var newLeft = upMax + points[r][lc] - (c - lc);
                    if (max[r][lc] >= newLeft) break;
                    max[r][lc] = newLeft;
                    lc--;
                }

                // 오른쪽 값들
                var rc = c + 1;
                while (rc < col) {
                    var newRight = upMax + points[r][rc] - (rc - c);
                    if (max[r][rc] >= newRight) break;
                    max[r][rc] = newRight;
                    rc++;
                }

            }
        }

        return Arrays
                .stream(max[row - 1])
                .max()
                .orElseThrow();
    }

}
