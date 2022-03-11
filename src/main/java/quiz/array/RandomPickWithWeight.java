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

    private final List<Double> probabilities = new ArrayList<>();
    private final List<Double> picked = new ArrayList<>();
    private int pickTotalCount = 0;

    public RandomPickWithWeight(int[] w) {
        var sum = Arrays.stream(w).sum();

        for (int n : w) {
            probabilities.add((double) n / sum);
            picked.add(0d);
        }
    }

    public int pickIndex() {
        for (int i = 0; i < picked.size(); i++) {
            if (pickTotalCount == 0 || picked.get(i) / pickTotalCount <= probabilities.get(i)) {
                picked.set(i, picked.get(i) + 1);
                pickTotalCount++;
                return i;
            }
        }

        throw new IllegalStateException();
    }

}
