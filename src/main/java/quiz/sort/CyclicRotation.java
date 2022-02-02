package quiz.sort;

/**
 * Task description
 * A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is also moved to the first place.
 * <p>
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate array A K times; that is, each element of A will be shifted to the right by K indexes.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int K); }
 * <p>
 * that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p>
 * For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
class CyclicRotation {

    int[] execute(int[] A, int K) {
        if (A.length == 0) {
            return A;
        }

        int[] result = new int[A.length];
        int distance = K % A.length;

        for (int i = 0; i < A.length; i++) {
            if (i + distance >= A.length) {
                result[i + distance - A.length] = A[i];
            } else {
                result[i + distance] = A[i];
            }
        }

        return result;
    }

    int[] byReverse(int[] A, int K) {
        if (A.length == 0) return A;

        final int end = A.length - 1;
        final int mid = end - (K % A.length);

        reverse(A, 0, mid);
        reverse(A, mid + 1, end);
        reverse(A, 0, end);

        return A;
    }

    private void reverse(int[] A, int start, int end) {
        if (end < start) return;

        final int mid = (start + end) / 2;
        for (int i = 0; i <= mid - start; i++) {
            swap(A, start + i, end - i);
        }
    }

    private void swap(int[] A, int i1, int i2) {
        final int temp = A[i1];
        A[i1] = A[i2];
        A[i2] = temp;
    }
}
