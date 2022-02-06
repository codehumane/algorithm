package sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MergeSort implements Sort {

    public void sort(int[] input) {
        log.info("MergeSort start");

        divideSort(input, 0, input.length - 1);
    }

    private void divideSort(int[] input, int from, int to) {
        if (to <= from) return;

        int mid = (to + from) / 2;
        divideSort(input, from, mid);
        divideSort(input, mid + 1, to);
        merge(input, from, mid, to);
    }

    private void merge(int[] input, int from, int mid, int to) {
        final int[] l = Arrays.copyOfRange(input, from, mid + 1);
        final int[] r = Arrays.copyOfRange(input, mid + 1, to + 1);

        int li = 0;
        int ri = 0;

        for (int i = from; i <= to; i++) {
            if (li == l.length || (ri < r.length && r[ri] < l[li])) {
                input[i] = r[ri++];
            } else {
                input[i] = l[li++];
            }
        }
    }

}
