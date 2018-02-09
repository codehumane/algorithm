package quiz;

/**
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N+M);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */
class MaxCounters {

    int[] solution(int N, int[] A) {

        int max = 0;
        int M = A.length;
        int[] counters = new int[N];

        for (int K = 0; K < M; K++) {
            if (1 <= A[K] && A[K] <= N) {
                max = increase(A, K, counters, max);
            }

            if (A[K] == N + 1) {
                maxCounter(counters, max);
            }
        }

        return counters;
    }

    private int increase(int[] A, int X, int[] counters, int max) {
        int at = A[X] - 1;
        counters[at] += 1;
        if (counters[at] > max) {
            max = counters[at];
        }

        return max;
    }

    private void maxCounter(int A[], int max) {
        for (int i = 0; i < A.length; i++) {
            A[i] = max;
        }
    }
}
