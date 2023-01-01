package quiz.math;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

    private final ThreeSum solution = new ThreeSum();

    @Test
    void example1() {
        var nums = new int[]{-1, 0, 1, 2, -1, -4};
        var expected = List.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
        );
        var result = solution.threeSum(nums);
        assertTriplet(expected, result);
    }

    @Test
    void example2() {
        var nums = new int[]{0, 1, 1};
        var expected = new ArrayList<List<Integer>>();
        var result = solution.threeSum(nums);
        assertTriplet(expected, result);
    }

    @Test
    void example3() {
        var nums = new int[]{0, 0, 0};
        var expected = List.of(
                List.of(0, 0, 0)
        );
        var result = solution.threeSum(nums);
        assertTriplet(expected, result);
    }

    @Test
    void custom1() {
        var nums = new int[]{3, -1, 0, 1, 1, -2, 3, 0, 0};
        var expected = List.of(
                List.of(-2, -1, 3),
                List.of(-2, 1, 1),
                List.of(-1, 0, 1),
                List.of(0, 0, 0)
        );
        var result = solution.threeSum(nums);
        assertTriplet(expected, result);
    }

    private void assertTriplet(List<List<Integer>> expected, List<List<Integer>> result) {
        var expectedTriplets = toTriplets(expected);
        var resultTriplets = toTriplets(result);
        assertEquals(expectedTriplets, resultTriplets);
    }

    private Set<Triplet> toTriplets(List<List<Integer>> expected) {

        return expected
                .stream()
                .map(l -> new Triplet(l.get(0), l.get(1), l.get(2)))
                .collect(Collectors.toSet());
    }

    static class Triplet {

        int n1;
        int n2;
        int n3;

        public Triplet(int n1, int n2, int n3) {
            this.n1 = n1;
            this.n2 = n2;
            this.n3 = n3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Triplet triplet = (Triplet) o;

            var mine = new HashSet<>(List.of(n1, n2, n3));
            var other = new HashSet<>(List.of(triplet.n1, triplet.n2, triplet.n3));
            return mine.equals(other);
        }

        @Override
        public int hashCode() {
            return new HashSet<>(List.of(n1, n2, n3)).hashCode();
        }
    }
}