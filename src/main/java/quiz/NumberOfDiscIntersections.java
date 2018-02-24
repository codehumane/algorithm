package quiz;

/**
 * Given array A shown above, the function should return 11, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647]. 2,147,483,647 => 9,999,900,000
 */
public class NumberOfDiscIntersections {

    int solution(int[] A) {

        int count = 0;

        for (int J = 0; J < A.length - 1; J++) {
            for (int K = J + 1; K < A.length; K++) {
                if (hasIntersect(A, J, K)) {
                    count++;
                }
                if (count == 10000000) {
                    return -1;
                }
            }
        }

        return count;
    }

    private boolean hasIntersect(int[] A, int J, int K) {

        int minJ = J - A[J];
        int maxJ = J + A[J];
        int minK = K - A[K];
        int maxK = K + A[K];

        return minJ <= maxK && maxJ >= minK;
    }
}
