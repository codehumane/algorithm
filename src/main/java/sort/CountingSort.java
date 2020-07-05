package sort;

import java.util.Arrays;

/**
 * array 원소들은 모두 0 이상이라고 가정.
 */
public class CountingSort implements Sort {

    @Override
    public void sort(int[] array) {
        final int max = max(array);
        final int[] counting = new int[max + 1];
        final int[] result = new int[array.length];

        for (int element : array) {
            counting[element]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

//        for (int i = array.length - 1; i >= 0; i--) {
//            result[counting[array[i]] - 1] = array[i];
//            counting[array[i]]--;
//        }

        int index = 0;
        for (int i = 0; i < counting.length; i++) {
            int count = (i == 0) ? counting[i] : counting[i] - counting[i - 1];
            while (count > 0) {
                result[index++] = i;
                count--;
            }
        }

        System.arraycopy(result, 0, array, 0, result.length);
    }

    private int max(int[] array) {
        return Arrays
                .stream(array)
                .max()
                .orElse(0);
    }
}
