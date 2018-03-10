package quiz;

class MaxSliceSum {

    int solution(int[] A) {

        final int N = A.length;
        int maxSum = A[0];

        for (int P = 0; P < N; P++) {

            int sum = 0;
            for (int Q = P; Q < N; Q++) {

                sum += A[Q];
                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        return maxSum;
    }
}
