package sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuickSort implements Sort {

    @Override
    public void sort(int[] list) {
        log.info("quick-sort");
        sort(list, 0, list.length - 1);
    }

    private void sort(int[] list, int start, int end) {
        if (end - start < 1) {
            return;
        }

//        log.debug("before : {} {} ~ {}", Arrays.toString(list), start, end);
        int criteria = partitionV1(list, start, end);
//        log.debug("after  : {}", Arrays.toString(list));

        sort(list, start, criteria - 1);
        sort(list, criteria + 1, end);
    }

    private int partitionV1(int[] list, int start, int end) {
        int left = start;
        int right = end;

        while (left < right) {
            if (list[left] > list[left + 1]) {
                swap(list, left, left + 1);
                left++;
            } else {
                swap(list, right, left + 1);
                right--;
            }
        }

        return left;
    }

    /**
     * 3,1,4,6,2,5 (given) <br/>
     *
     * 3,1,5,6,2,4 (move criteria[4] to rightmost)<br/>
     *
     * idx: 0<br/>
     * 3,1,5,6,2,4 (0:0)<br/>
     * 3,1,5,6,2,4 (0:1)<br/>
     *
     * idx: 1<br/>
     * 3,1,5,6,2,4 (1:1)<br/>
     * 3,1,5,6,2,4 (1:2)<br/>
     *
     * idx: 2 bigger<br/>
     * 3,1,5,6,2,4 (2:2)<br/>
     * 3,1,5,6,2,4 (2:2)<br/>
     *
     * idx: 3 bigger<br/>
     * 3,1,5,6,2,4 (3:2)<br/>
     * 3,1,5,6,2,4 (3:2)<br/>
     *
     * idx: 4<br/>
     * 3,1,5,6,2,4 (4:2)<br/>
     * 3,1,2,6,5,4 (4:3)<br/>
     *
     * 3,1,2,4,5,6 swap leftIdx with rightmost.
     * And leftIdx is newCriteriaIdx<br/>
     **/
    private int partitionV2(int[] list, int start, int end) {
        int criteria = (start + end) / 2;
        int criteriaValue = list[criteria];
        swap(list, criteria, end);

        int leftIdx = start;
        for (int i = start; i < end; i++) {
            if (list[i] < criteriaValue) {
                swap(list, leftIdx, i);
                leftIdx++;
            }
        }

        swap(list, leftIdx, end);
        return leftIdx;
    }

    private void swap(int[] list, int idx1, int idx2) {
        Integer temp = list[idx1];
        list[idx1] = list[idx2];
        list[idx2] = temp;
    }

    private void set(int[] source, int[] target, int idxFrom, int idxTo) {
        for (int i = idxFrom; i <= idxTo; i++) {
            target[i] = source[i];
        }
    }
}
