package hackerrank.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripleSum {

    static long triplets(int[] a, int[] b, int[] c) {

        // 예제로만 보면 주어진 배열들이 정렬되어 있음. 하지만 설명에는 명시되어 있지 않음.
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        long count = 0L;
        final Set<Integer> calculated = new HashSet<>();

        // 배열 안에 중복된 숫자가 있을 수 있음.
        for (int number : b) {

            if (calculated.contains(number)) continue;
            calculated.add(number);

            final long left = Arrays.stream(a).filter(x -> x <= number).count();
            final long right = Arrays.stream(c).filter(x -> x <= number).count();
            count += left * right;

        }

        return count;
    }

}
