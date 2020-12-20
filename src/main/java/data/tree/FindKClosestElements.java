package data.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <br/>
 * <br/>
 * An integer a is closer to x than an integer b if:
 * <br/>
 * <br/>
 * - |a - x| < |b - x|, or
 * <p>
 * - |a - x| == |b - x| and a < b
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        final int target = search(arr, x, 0, arr.length - 1);
        return extract(arr, x, target, k);
    }

    int search(int[] arr, int x, int l, int r) {
        if (r <= l) return l;
        if (l >= arr.length) return arr.length - 1;
        if (r < 0) return 0;

        final int m = l + (r - l) / 2;

        if (isClosest(arr, m, x)) return m;
        if (arr[m] > x) return search(arr, x, l, m - 1);
        return search(arr, x, m + 1, r);
    }

    private boolean isClosest(int[] arr, int m, int x) {
        final int target = arr[m];
        final int next = arr[m + 1];

        return target <= x
                && next > x
                && (Math.abs(arr[m] - x) < Math.abs(next - x) || Math.abs(arr[m] - x) == Math.abs(next - x) && arr[m] < next);
    }

    List<Integer> extract(int[] arr, int x, int xi, int k) {
        final List<Integer> elements = new ArrayList<>();
        int to = Math.min(arr.length - 1, xi + k - 1);
        int from = Math.max(0, xi - k + 1);

        while (to - from > k - 1) {
            if (x - arr[from] <= arr[to] - x) to--;
            else from++;
        }

        for (int i = from; i <= to; i++) {
            elements.add(arr[i]);
        }

        return elements;
    }

}
