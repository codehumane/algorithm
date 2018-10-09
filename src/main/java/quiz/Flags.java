package quiz;

import java.util.Arrays;

import static java.lang.Math.max;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
 */
public class Flags {

    public int solution(int[] A) {

        int N = A.length;
        if (N <= 2) return 0;
        int[] peaks = findPeaks(A, N);
        return findMaxFlags(peaks, N);
    }

    private int[] findPeaks(int[] A, int N) {
        int[] peaks = new int[(N - 2) / 2 + 1];
        int peaksCount = 0;

        for (int i = 1; i < N - 1; i++) {
            if (A[i] > max(A[i - 1], A[i + 1])) {
                peaks[peaksCount] = i;
                peaksCount++;
            }
        }

        return Arrays.copyOf(peaks, peaksCount);
    }

    private int findMaxFlags(int[] peaks, int N) {
        if (peaks.length <= 1) return peaks.length;

        int maxFlags = 0;

        for (int d = 2; isValidDistance(d, N); d++) {
            int flags = 1;
            int previousPeak = peaks[0];

            for (int peak : peaks) {
                if (flags >= d) continue;
                if (peak - previousPeak < d) continue;
                previousPeak = peak;
                flags++;
            }

            maxFlags = max(maxFlags, flags);
        }

        return maxFlags;
    }

    /**
     * A                                                                     | result
     * [0, 1, 0]                                                             | 1 // 예외
     * [0, 1, 0, 1, 0]                                                       | 2 // 2 * 1 + 3 = 5
     * [0, 1, 0, 0, 1, 0, 0, 1, 0]                                           | 3 // 3 * 2 + 3 = 9
     * [0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0]                         | 4 // 4 * 3 + 3 = 15
     * [0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0] | 5 // 5 * 4 + 3 = 23
     * <p>
     * 따라서, distance를 d라고 할 때(2부터 시작함),
     * d * (d - 1) + 3이 N(A의 길이)보다 작거나 같은 경우만 조사하면 된다.
     * 시간 복잡도는 대략 O(N * log N)이 되는 것.
     */
    private boolean isValidDistance(int d, int N) {
        return d * (d - 1) + 3 <= N;
    }
}
