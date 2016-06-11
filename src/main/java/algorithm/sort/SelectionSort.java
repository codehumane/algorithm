package algorithm.sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SelectionSort implements Sort {

    public void sort(int[] list) {
        log.info("selection-sort");
//        sortNormally(list);
        sortEffectively(list);
    }

    private void sortEffectively(int[] list) {
        for (int i = 0; i < list.length; i++) {

            int minimumIndex = i;
            boolean swapped = false;

            for (int j = i; j < list.length; j ++) {
                if (list[minimumIndex] > list[j]) {
                    minimumIndex = j;
                    swapped = true;
                }
            }

            if (!swapped) {
                return;
            }

            swap(list, i, minimumIndex);
//            log.debug("{}", list);
        }
    }

    private void sortNormally(int[] input) {
        for (int i = 0; i < input.length; i++) {

            int minimumIndex = i;
            for (int j = i; j < input.length; j ++) {
                if (input[minimumIndex] > input[j]) {
                    minimumIndex = j;
                }
            }

            swap(input, i, minimumIndex);
//            log.debug("{}", input);
        }
    }

    private void swap(int[] list, int idx1, int idx2) {
        Integer temp = list[idx1];
        list[idx1] = list[idx2];
        list[idx2] = temp;
    }
}
