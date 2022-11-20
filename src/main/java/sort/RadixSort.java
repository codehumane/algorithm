package sort;

import lombok.extern.slf4j.Slf4j;

/**
 * https://www.geeksforgeeks.org/radix-sort/
 */
@Slf4j
public class RadixSort {

    public void sort(int[] input) {
        if (input.length < 2) return;

        var digit = 1;
        var max = max(input);

        while (max >= digit) {
            countingSort(input, digit);
            digit *= 10;
        }
    }

    private int max(int[] input) {
        var max = input[0];
        for (int i = 1; i < input.length; i++) {
            max = Math.max(max, input[i]);
        }

        return max;
    }

    // e.g. 256 336 736 443 831 907
    private void countingSort(int[] input, int digit) {
        var temp = new int[input.length];
        var count = new int[10];

        // 0 1 0 1 0 0 3 1 0 0
        for (int num : input) {
            count[digitNumber(num, digit)]++;
        }

        // 0 1 1 2 2 2 5 6 6 6
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 0 1 1 2 2 2 5 6 6 6
        // 0 1 1 2 2 2 5 5 6 6
        // 0 0 1 2 2 2 5 5 6 6
        // 0 0 1 1 2 2 5 5 6 6
        // 0 0 1 1 2 2 4 5 6 6
        // 0 0 1 1 2 2 3 5 6 6
        // 0 0 1 1 2 2 2 5 6 6
        for (int i = input.length - 1; i >= 0; i--) {
            var num = input[i];
            var digitNum = digitNumber(num, digit);
            temp[count[digitNum] - 1] = num;
            count[digitNum]--;
        }

        // 단순 복사
        log.debug("digit: {}, before: {}, after: {}", digit, input, temp);
        System.arraycopy(temp, 0, input, 0, input.length);
    }

    private int digitNumber(int num, int digit) {
        return (num / digit) % 10;
    }

}
