package quiz.math;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 */
public class ProductOfTheLastNumbers {

    private final List<Long> productions = new ArrayList<>();

    public ProductOfTheLastNumbers() {
    }

    public void add(int num) {
        if (num == 0) {
            productions.clear();
            return;
        }

        if (num != 1) {
            for (int i = 0; i < productions.size(); i++) {
                productions.set(i, productions.get(i) * num);
            }
        }

        productions.add((long) num);
    }

    public int getProduct(int k) {
        if (k > productions.size()) return 0;

        return productions
                .get(productions.size() - k)
                .intValue();
    }

}
