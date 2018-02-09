package quiz;

import lombok.extern.slf4j.Slf4j;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N+M);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */
@Slf4j
class MaxCounters {

    int[] solution(int N, int[] A) {

        int max = 0;
        int maxToApply = 0;
        int M = A.length;
        int[] counters = new int[N];

        for (int K = 0; K < M; K++) {
            if (1 <= A[K] && A[K] <= N) {
                max = increase(A, K, counters, max, maxToApply);
            }

            if (A[K] == N + 1) {
                maxToApply = max;
            }
        }

        if (maxToApply > 0) {
            maxCounter(counters, maxToApply);
        }

        return counters;
    }

    private int increase(int[] A, int X, int[] counters, int max, int maxToApply) {
        int at = A[X] - 1;
        if (counters[at] < maxToApply) {
            counters[at] = maxToApply;
        }

        counters[at] += 1;
        if (counters[at] > max) return counters[at];
        else return max;
    }

    private void maxCounter(int A[], int max) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] < max) {
                A[i] = max;
            }
        }
    }
}
