package hackerrank.search;

import java.util.Arrays;

public class TripleSum {

    static long triplets(int[] a, int[] b, int[] c) {
        final int[] as = toSortedDistinctArray(a);
        final int[] bs = toSortedDistinctArray(b);
        final int[] cs = toSortedDistinctArray(c);

        long aCnt = 0;
        long cCnt = 0;
        int aIdx = 0;
        int cIdx = 0;

        long triplets = 0L;

        for (int n : bs) {
            while (aIdx < as.length && as[aIdx] <= n) {
                aCnt++;
                aIdx++;
            }

            while (cIdx < cs.length && cs[cIdx] <= n) {
                cCnt++;
                cIdx++;
            }

            triplets += aCnt * cCnt;
        }

        return triplets;
    }

    private static int[] toSortedDistinctArray(int[] a) {
        return Arrays
                .stream(a)
                .distinct()
                .sorted()
                .toArray();
    }

}
