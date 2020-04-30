package hackerrank.search;

import java.util.HashMap;
import java.util.Map;

public class IceCreamParlor {

    static void whatFlavors(int[] cost, int money) {
        final int[] flavors = getFlavors(cost, money);
        System.out.println(flavors[0] + " " + flavors[1]);
    }

    static int[] getFlavors(int[] cost, int money) {
        final Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < cost.length; i++) {
            if (indices.containsKey(money - cost[i]))
                return new int[]{indices.get(money - cost[i]) + 1, i + 1};

            indices.put(cost[i], i);
        }

        throw new IllegalStateException();
    }

}
