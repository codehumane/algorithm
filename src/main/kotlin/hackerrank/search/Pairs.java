package hackerrank.search;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Pairs {

    static int pairs(int k, int[] arr) {

        final Set<Integer> numbers = Arrays
                .stream(arr)
                .boxed()
                .collect(Collectors.toSet());

        final long count = Arrays
                .stream(arr)
                .filter(n -> numbers.contains(n - k))
                .count();

        return Long
                .valueOf(count)
                .intValue();
    }

}
