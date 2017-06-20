package sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsertionSort implements Sort {

    public void sort(int[] list) {
        log.info("insertion-sort");
//        sortNormally(list);
        sortEffectively(list);
    }

    private void sortEffectively(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int cached = list[i];
            int idx = i;

            while (idx > 0 && list[idx - 1] > cached) {
                list[idx] = list[idx - 1];
                idx = idx - 1;
            }

            list[idx] = cached;

//            log.debug("{}", list);
        }
    }

    private void sortNormally(int[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j] < list[j - 1]) {
                    swap(list, j, j-1);
                }
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
