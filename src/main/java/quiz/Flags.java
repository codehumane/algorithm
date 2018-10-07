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
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks[peaksCount] = i;
                peaksCount++;
            }
        }

        return Arrays.copyOf(peaks, peaksCount);
    }

    private int findMaxFlags(int[] peaks, int N) {
        if (peaks.length <= 1) return peaks.length;
        int maxFlags = 0;

        for (int d = 2; d < N - 2; d++) {
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
}
