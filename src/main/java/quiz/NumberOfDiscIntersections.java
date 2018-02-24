package quiz;

class NumberOfDiscIntersections {

    private static final int EXCEED_PAIRS_COUNT = 10000000;

    int solution(int[] A) {

        int count = 0;
        for (int J = 0; J < A.length - 1; J++) {
            for (int K = J + 1; K < A.length; K++) {
                if (hasIntersect(A, J, K))
                    count++;

                if (count == EXCEED_PAIRS_COUNT)
                    return -1;
            }
        }

        return count;
    }

    //     |----|       (비교 대상)
    //  |---|           (O)
    //         |----|   (O)
    // |-------------|  (O)
    //      |-|         (O)
    // |-|              (X)
    //            |-|   (X)
    private boolean hasIntersect(int[] A, int J, int K) {

        long minJ = (long) J - A[J];
        long maxJ = (long) J + A[J];
        long minK = (long) K - A[K];
        long maxK = (long) K + A[K];

        return minJ <= maxK && maxJ >= minK;
    }
}
