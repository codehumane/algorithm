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

    public RandomPickWithWeight(int[] w) {
        solution1 = new BasedOnPickedStatistic(w);
    }

    public int pickIndex() {
        return solution1.pickIndex();
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
