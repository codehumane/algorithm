package hackerrank.search;

import java.util.Arrays;

public class TripleSum {

    static long triplets(int[] a, int[] b, int[] c) {

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        long aCount = 0;
        long cCount = 0;
        int aIndex = 0;
        int cIndex = 0;
        long count = 0L;
        int bCurrent = 0;

        for (int n : b) {

            // 같은 값이 존재할 수 있음.
            if (n <= bCurrent) continue;
            bCurrent = n;

            while (aIndex < a.length && a[aIndex] <= n) {
                // 같은 값이 존재할 수 있음.
                if (aIndex == 0 || a[aIndex - 1] != a[aIndex]) {
                    aCount++;
                }

                aIndex++;
            }

            while (cIndex < c.length && c[cIndex] <= n) {
                // 같은 값이 존재할 수 있음.
                if (cIndex == 0 || c[cIndex - 1] != c[cIndex]) {
                    cCount++;
                }

                cIndex++;
            }

            count += aCount * cCount;
        }

        return count;
    }

}
