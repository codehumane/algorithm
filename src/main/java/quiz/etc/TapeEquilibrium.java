package quiz.etc;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
class TapeEquilibrium {

    int solution(int[] A) {

        int sumTotal = 0;
        for (int a : A) {
            sumTotal += a;
        }

        int sumLeft = 0;
        int diffMin = 0;
        for (int i = 1; i < A.length; i++) {
            sumLeft += A[i - 1];
            int curDiff = Math.abs(sumLeft - (sumTotal - sumLeft));
            if (i == 1) diffMin = curDiff;
            if (diffMin > curDiff) {
                diffMin = curDiff;
            }
        }

        return diffMin;
    }
}
