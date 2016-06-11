package algorithm.sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BubbleSort implements Sort {

    public void sort(int[] list) {
        log.info("bubble-sort");
//        byWhileStatement(list);
        effectively(list);
    }

    private void effectively(int[] list) {
        while (true) {
            int swappedIdx = list.length;
            boolean swapped = false;

            for (int i = 1; i < swappedIdx; i++) {
                if (list[i - 1] > list[i]) {
                    swap(list, i - 1, i);
                    swappedIdx = i - 1;
                    swapped = true;
                }
            }

            if (!swapped) {
                return;
            }

//            log.debug("{}", list);
        }
    }

    private void byWhileStatement(int[] list) {
        while (true) {
            boolean swapped = false;
            for (int i = 1; i < list.length; i++) {
                if (list[i - 1] > list[i]) {
                    swap(list, i - 1, i);
                    swapped = true;
                }
            }

            if (!swapped) {
                return;
            }

//            log.debug("{}", list);
        }
    }

    private void swap(int[] list, int idx1, int idx2) {
        Integer temp = list[idx1];
        list[idx1] = list[idx2];
        list[idx2] = temp;
    }
}
