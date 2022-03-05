package quiz.etc;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 */
class PermMissingElement {

    int solution(int[] A) {

        int N = A.length;
        int sumOfA = 0;
        int sum1ToN1 = N + 1;

        for (int i = 0; i < N; i++) {
            sumOfA += A[i];
            sum1ToN1 += i + 1;
        }

        return sum1ToN1 - sumOfA;
    }
}
