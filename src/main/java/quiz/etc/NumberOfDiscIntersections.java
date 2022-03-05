package quiz.etc;

import java.util.Arrays;

class NumberOfDiscIntersections {

    /**
     * O(N*log(N))은 아래 링크 참고.
     * https://stackoverflow.com/a/4801275
     */
    int solution(int[] A) {
        Disc[] discs = toDiscs(A);
        Arrays.sort(discs);
        return intersect(discs);
    }

    private Disc[] toDiscs(int[] A) {
        Disc[] discs = new Disc[A.length];
        for (int i = 0; i < A.length; i++) {
            discs[i] = new Disc((long) i - A[i], (long) i + A[i]);
        }

        return discs;
    }

    private int intersect(Disc[] discs) {

        int count = 0;
        for (int i = 0; i < discs.length - 1; i++) {
            count += intersect(discs, i, i + 1, discs.length - 1);
            if (count > 10000000)
                return -1;
        }

        return count;
    }

    private int intersect(Disc[] discs, int compare, int from, int to) {

        if (to - from == 0)
            return discs[from].left <= discs[compare].right ? 1 : 0;

        int mid = (from + to) / 2;
        if (discs[mid].left <= discs[compare].right) {
            return intersect(discs, compare, mid + 1, to) + (mid - from + 1);
        } else {
            return intersect(discs, compare, from, mid);
        }
    }

    private class Disc implements Comparable<Disc> {

        private final long left;
        private final long right;

        Disc(long left, long right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Disc o) {
            return Long.compare(this.left, o.left);
        }
    }
}
