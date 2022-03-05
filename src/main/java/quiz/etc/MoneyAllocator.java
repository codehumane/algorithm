package quiz.etc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.function.BiFunction;

import static java.lang.Math.min;

class MoneyAllocator {

    static int allocate(Collection<Target> targets, int totalAmount) {
        return targets.stream().reduce(0, targetAllocator(totalAmount), Integer::sum);
    }

    private static BiFunction<Integer, Target, Integer> targetAllocator(int totalAmount) {
        return (accumulatedAllocatedAmount, target) -> {
            final int leftMoney = totalAmount - accumulatedAllocatedAmount;
            final int allocation = min(leftMoney, target.getMaxAmount());
            target.setAllocatedAmount(allocation);
            return accumulatedAllocatedAmount + allocation;
        };
    }

    @Getter
    @RequiredArgsConstructor
    static class Target {

        private final String name;
        private final int maxAmount;

        @Setter
        private int allocatedAmount;
    }

}
