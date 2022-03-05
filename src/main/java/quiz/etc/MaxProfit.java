package quiz.etc;

import static java.lang.Math.max;

class MaxProfit {

    int solution(int[] A) {
        if (A.length < 1) return 0;

        int maxProfit = 0;
        int bought = A[0];
        int sold = A[0];

        for (int a : A) {
            if (a > sold) {
                sold = a;
                maxProfit = max(maxProfit, sold - bought);
            }

            if (a < bought) {
                bought = a;
                sold = a;
            }
        }

        return maxProfit;
    }
}
