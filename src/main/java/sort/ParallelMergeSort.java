package sort;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

@Slf4j
public class ParallelMergeSort implements Sort {

    private static final ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

    @Override
    public void sort(int[] input) {
        int idxFrom = 0;
        int idxTo = input.length - 1;
        int[] result = new int[input.length];
        forkJoinPool.invoke(new SortTask(input, result, idxFrom, idxTo));
    }

    private class SortTask extends RecursiveAction {

        private int[] input;
        private int[] result;
        private int idxFrom;
        private int idxTo;

        SortTask(int[] input, int[] result, int idxFrom, int idxTo) {
            this.input = input;
            this.result = result;
            this.idxFrom = idxFrom;
            this.idxTo = idxTo;
        }

        @Override
        protected void compute() {
            if (idxTo - idxFrom < 1) {
                return;
            }

            int idxMid = (idxTo + idxFrom) / 2;
            SortTask left = new SortTask(input, result, idxFrom, idxMid);
            SortTask right = new SortTask(input, result, idxMid + 1, idxTo);

            left.fork();
            right.compute();
            left.join();

            merge(input, idxFrom, idxMid, idxTo, result);
            set(result, input, idxFrom, idxTo);
        }

        private void merge(int[] input, int idxFrom, int idxMid, int idxTo, int[] result) {
            int i = idxFrom, j = idxMid + 1;
            for (int k = idxFrom; k <= idxTo; k++) {
                if (i <= idxMid && (j > idxTo || input[i] < input[j])) {
                    result[k] = input[i++];
                } else {
                    result[k] = input[j++];
                }
            }
        }

        private void set(int[] source, int[] target, int idxFrom, int idxTo) {
            for (int i = idxFrom; i <= idxTo; i++) {
                target[i] = source[i];
            }
        }
    }

}
