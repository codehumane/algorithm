package hackerrank.search;

import java.util.Arrays;

public class MinimumTimeRequired {

    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);

        return findMinTime(
                machines,
                goal,
                1,
                machines[machines.length - 1] * goal
        );
    }

    private static long findMinTime(long[] machines, long goal, long minDays, long maxDays) {
        if (minDays == maxDays) return minDays;

        final long halfDays = (minDays + maxDays) / 2;
        final long count = Arrays
                .stream(machines)
                .map(m -> halfDays / m)
                .sum();

        if (count < goal) return findMinTime(
                machines,
                goal,
                halfDays + 1,
                maxDays
        );
        else return findMinTime(
                machines,
                goal,
                minDays,
                halfDays
        );
    }

}
