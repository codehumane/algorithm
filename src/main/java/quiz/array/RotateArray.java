package quiz.array;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.<br/>
 * <br/>
 * Follow up:<br/>
 * <br/>
 * - Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.<br/>
 * - Could you do it in-place with O(1) extra space?<br/>
 * <br/>
 * https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/
 */
public class RotateArray {

    private final ReverseRotateArray reverse = new ReverseRotateArray();
    private final CyclicReplaceRotateArray cyclic = new CyclicReplaceRotateArray();

    public void rotate(int[] nums, int k) {
        final int[] copy = Arrays.copyOf(nums, nums.length);

        reverse.rotate(nums, k);
        cyclic.rotate(copy, k);

        if (!Arrays.equals(nums, copy)) {
            throw new IllegalStateException();
        }
    }

    static class CyclicReplaceRotateArray {

        void rotate(int[] nums, int k) {
            final int N = nums.length;
            k = k % N;

            if (k == 0) return;

            int count = 0;
            int start = 0;

            while (count < N) {

                int current = start;
                int temp = nums[start];

                do {
                    final int to = (current + k) % N;
                    final int toValue = nums[to];
                    nums[to] = temp;
                    temp = toValue;

                    current = (current + k) % N;
                    count++;
                } while (start != current);

                start++;
            }
        }

    }

    static class ReverseRotateArray {

        void rotate(int[] nums, int k) {
            final int move = k % nums.length;

            if (move == 0) return;

            reverse(nums, nums.length - move, nums.length - 1);
            reverse(nums, 0, nums.length - move - 1);
            reverse(nums, 0, nums.length - 1);
        }

        private void reverse(int[] nums, int from, int to) {
            for (int i = 0; i <= (to - from) / 2; i++) {
                swap(nums, from + i, to - i);
            }
        }

        private void swap(int[] nums, int i1, int i2) {
            final int temp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = temp;
        }

    }

}
