package quiz;

import static java.lang.Math.max;

import lombok.extern.slf4j.Slf4j;

/**
 * refer. https://en.wikipedia.org/wiki/Maximum_subarray_problem
 */
@Slf4j
class MaxSliceSum {

    int solution(int[] A) {

        int subSumHere = 0;
        int maxSubSum = 0;

        for (int a : A) {
            subSumHere = max(subSumHere + a, a);
            maxSubSum = max(maxSubSum, subSumHere);
        }

        return maxSubSum;
    }
}
