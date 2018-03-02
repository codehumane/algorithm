package quiz;

import java.util.Arrays;

class Dominator {

    int solution(int[] A) {

        if (A.length == 0) return -1;

        int count = 0;
        int index = -1;
        final int mid = A.length / 2;
        final int[] sorted = Arrays.copyOf(A, A.length);
        Arrays.sort(sorted);

        for (int i = 0; i < A.length; i++) {
            if (sorted[mid] == A[i]) {
                count++;
                index = i;
            }
        }

        return count > mid ? index : -1;
    }
}
