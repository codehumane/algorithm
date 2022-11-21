package sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class CountingSort2022 implements Sort {

    @Override
    public void sort(int[] list) {
        if (list.length == 0) return;

        var counts = counts(list);
        accumulate(counts);
        var sorted = sort(list, counts);
        log.debug("before: {}, after: {}", list, sorted);
        System.arraycopy(sorted, 0, list, 0, list.length);
    }

    private int[] counts(int[] list) {
        var max = Arrays.stream(list).max().orElseThrow();
        var counts = new int[max + 1];

        for (int num : list) {
            counts[num]++;
        }

        return counts;
    }

    private void accumulate(int[] counts) {
        var startIdx = 0;

        for (int i = 0; i < counts.length; i++) {
            var count = counts[i];
            counts[i] = startIdx;
            startIdx += count;
        }
    }

    private int[] sort(int[] list, int[] counts) {
        var sorted = new int[list.length];

        for (int num : list) {
            sorted[counts[num]++] = num;
        }

        return sorted;
    }

}
