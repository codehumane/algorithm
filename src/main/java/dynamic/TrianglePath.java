package dynamic;

/**
 * 삼각형으로 배치된 자연수들이 있다.
 * 맨 위의 숫자부터 시작해서, 한번에 한칸씩 아애로 내려가 맨 아래줄 숫자로 내려간다.
 * 내려갈때는 바로 아래 혹은 오른쪽 아래 숫자로만 이동이 가능하다.
 * 모든 경로 중 숫자의 합이 가장큰 경로는 무엇인가?
 * 또한 그 합은 얼마인가?
 *
 * 동적계획 적용을 위해, 삼각형을 이루는 숫자의 라인은 최대 100까지로 한정함.
 */
class TrianglePath {

    static int sum(int[][] input) {
        final int start = input[0][0];
        if (input.length == 1) {
            return start;
        }

        int[][] cached = new int[100][100];
        return start + sum(1, 0, input, cached);
    }

    private static int sum(int row, int col, int[][] input, int[][] cached) {
        if (cached[row][col] > 0) {
            return cached[row][col];
        }

        final int below = input[row][col];
        final int next = input[row][col + 1];

        if (row == input.length - 1) {
            return max(below, next);
        }

        final int max = max(below + sum(row + 1, col, input, cached),
                next + sum(row + 1, col + 1, input, cached));

        cached[row][col] = max;
        return max;
    }

    private static int max(int left, int right) {
        return left > right ? left : right;
    }
}
