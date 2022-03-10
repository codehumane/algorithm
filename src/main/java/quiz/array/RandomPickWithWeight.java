package quiz.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/random-pick-with-weight/
 * <p>
 * pickIndex will be called at most 10^4 times.
 */
public class RandomPickWithWeight {

    private final Map<Integer, Integer> weights;
    private final int[] source;

    public RandomPickWithWeight(int[] w) {
        weights = new HashMap<>();
        source = w;
    }

    public int pickIndex() {
        initializeWeightsIfEmpty();
        return pick();
    }

    private void initializeWeightsIfEmpty() {
        if (!weights.isEmpty()) return;

        for (int i = 0; i < source.length; i++) {
            weights.put(i, source[i]);
        }
    }

    private Integer pick() {
        var picked = weights.entrySet().iterator().next();

        picked.setValue(picked.getValue() - 1);
        if (picked.getValue() == 0) {
            weights.remove(picked.getKey());
        }

        return picked.getKey();
    }

}
