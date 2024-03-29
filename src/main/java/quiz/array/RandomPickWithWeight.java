package quiz.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/random-pick-with-weight/
 * <p>
 * pickIndex will be called at most 10^4 times.
 */
public class RandomPickWithWeight {

    private final BasedOnPickedStatistic solution1;
    private final PrefixSumWithLinearSearch solution2;
    private final PrefixSumWithBinarySearch solution3;

    public RandomPickWithWeight(int[] w) {
        solution1 = new BasedOnPickedStatistic(w);
        solution2 = new PrefixSumWithLinearSearch(w);
        solution3 = new PrefixSumWithBinarySearch(w);
    }

    public int pickIndex() {
//        return solution1.pickIndex();
//        return solution2.pickIndex();
        return solution3.pickIndex();
    }

    static class PrefixSumWithBinarySearch {

        private final int[] prefixSums;
        private final int totalSum;

        public PrefixSumWithBinarySearch(int[] w) {
            prefixSums = new int[w.length];
            var prefixSum = 0;

            for (int i = 0; i < w.length; ++i) {
                prefixSum += w[i];
                prefixSums[i] = prefixSum;
            }

            totalSum = prefixSum;
        }

        public int pickIndex() {
            var target = totalSum * Math.random();
            return bs((int) target, 0, prefixSums.length - 1);
        }

        private int bs(int target, int from, int to) {
            if (from == to) return to;
            var mid = (from + to) / 2;

            if (prefixSums[mid] <= target) {
                return bs(target, mid + 1, to);
            } else {
                return bs(target, from, mid);
            }
        }
    }

    static class PrefixSumWithLinearSearch {

        private final int[] prefixSums;
        private final int totalSum;

        public PrefixSumWithLinearSearch(int[] w) {
            prefixSums = new int[w.length];
            var prefixSum = 0;

            for (int i = 0; i < w.length; ++i) {
                prefixSum += w[i];
                prefixSums[i] = prefixSum;
            }

            totalSum = prefixSum;
        }

        public int pickIndex() {
            var target = totalSum * Math.random();

            for (var i = 0; i < prefixSums.length; ++i) {
                if (target < prefixSums[i])
                    return i;
            }

            throw new IllegalStateException();
        }
    }

    static class BasedOnPickedStatistic {

        private final List<Double> probabilities = new ArrayList<>();
        private final List<Double> picked = new ArrayList<>();
        private int pickTotalCount = 0;

        public BasedOnPickedStatistic(int[] w) {
            var sum = Arrays.stream(w).sum();

            for (int n : w) {
                probabilities.add((double) n / sum);
                picked.add(0d);
            }
        }

        public int pickIndex() {
            var random = (int) (Math.random() * 100);
            for (int idx = random; idx < picked.size() + random; idx++) {

                var i = idx % picked.size();

                if (pickTotalCount == 0 || picked.get(i) / pickTotalCount <= probabilities.get(i)) {
                    picked.set(i, picked.get(i) + 1);
                    pickTotalCount++;
                    return i;
                }
            }

            throw new IllegalStateException();
        }
    }

}
