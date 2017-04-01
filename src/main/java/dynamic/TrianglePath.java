package dynamic;

import java.util.Arrays;

/**
 * 삼각형으로 배치된 자연수들이 있다.
 * 맨 위의 숫자부터 시작해서, 한번에 한칸씩 아애로 내려가 맨 아래줄 숫자로 내려간다.
 * 내려갈때는 바로 아래 혹은 오른쪽 아래 숫자로만 이동이 가능하다.
 * 모든 경로 중 숫자의 합이 가장큰 경로는 무엇인가?
 * 또한 그 합은 얼마인가?
 */
class TrianglePath {

    static int[] path(int[][] input) {
        int[] path = new int[input.length];

        // 최초 경로 입력 (고정위치 0,0)
        path[0] = input[0][0];

        // 2행 있는 경우에 한하여, 하위 경로 결정
        if (input.length > 1) {
            path = fillMaxPath(input, path, 1, 0);
        }

        return path;
    }

    private static int[] fillMaxPath(int[][] triangle, int[] path, int row, int column) {
        if (row + 1 == path.length) {
            int same = triangle[row][column];
            int right = triangle[row][column + 1];
            path[row] = (same > right) ? same : right;
            return path;
        }

        int[] same = Arrays.copyOf(path, path.length);
        same[row] = triangle[row][column];
        same = fillMaxPath(triangle, same, row + 1, column);

        int[] right = Arrays.copyOf(path, path.length);
        right[row] = triangle[row][column + 1];
        right = fillMaxPath(triangle, right, row + 1, column + 1);

        return sum(same) > sum(right) ? same : right;
    }


    static int sum(int[][] triangle) {
        return sum(path(triangle));
    }

    private static int sum(int[] path) {
        int sum = 0;
        for (int num : path) {
            sum += num;
        }

        return sum;
    }
}
