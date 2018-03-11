package quiz;

import static java.lang.Math.max;

class MaxProfit {

    int solution(int[] A) {

        final int N = A.length;
        int maxProfit = 0;

        for (int P = 0; P < N; P++) {
            int maxOfBoughtOnP = 0;
            for (int Q = P; Q < N; Q++) {
                maxOfBoughtOnP = max(maxOfBoughtOnP, A[Q] - A[P]);
            }

            maxProfit = max(maxProfit, maxOfBoughtOnP);
        }

        return maxProfit;
    }
}
