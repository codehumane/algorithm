package dynamic;

/**
 * 삼각형으로 배치된 자연수들이 있다.
 * 맨 위의 숫자부터 시작해서, 한번에 한칸씩 아애로 내려가 맨 아래줄 숫자로 내려간다.
 * 내려갈때는 바로 아래 혹은 오른쪽 아래 숫자로만 이동이 가능하다.
 * 모든 경로 중 숫자의 합이 가장큰 경로는 무엇인가?
 * 또한 그 합은 얼마인가?
 * <p>
 * 동적계획 적용을 위해, 삼각형을 이루는 숫자의 라인은 최대 100까지로 한정함.
 */
class TrianglePath {

    /**
     * 완전탐색의 경우 시간복잡도는 2^n
     * 동적계획을 적용한 경우 시간복잡도는 2^(n-1) = 2^(n-1) x 1 = (존재하는 부분 문제의 수) x (부분 문제별 필요한 반복문의 수)
     *
     * @param input 삼각형 (최대 라인수는 100)
     * @return 모든 경로중 합이 최대인 경로의 합
     */
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
