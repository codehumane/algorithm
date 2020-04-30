package hackerrank.search;

import lombok.Value;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Pairs {

    static int pairs(int k, int[] arr) {

        final Set<Integer> numbers = Arrays
                .stream(arr)
                .boxed()
                .collect(Collectors.toSet());

        final Set<Pair> pairs = new HashSet<>();

        for (int number : arr) {
            if (numbers.contains(number + k))
                pairs.add(new Pair(number, number + k));

            if (numbers.contains(number - k))
                pairs.add(new Pair(number - k, number));
        }

        return pairs.size();
    }

    static class Pair {

        private final Integer o1;
        private final Integer o2;

        public Pair(Integer o1, Integer o2) {
            this.o1 = (o1 > o2) ? o2 : o1;
            this.o2 = (o1 > o2) ? o1 : o2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (!o1.equals(pair.o1)) return false;
            return o2.equals(pair.o2);
        }

        @Override
        public int hashCode() {
            int result = o1.hashCode();
            result = 31 * result + o2.hashCode();
            return result;
        }
    }

}
