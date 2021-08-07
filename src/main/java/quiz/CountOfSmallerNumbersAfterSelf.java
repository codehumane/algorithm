package quiz;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].<br/>
 * <br/>
 * Constraints:<br/>
 * 1. 1 <= nums.length <= 105<br/>
 * 2. -104 <= nums[i] <= 104<br/>
 * <br/>
 * <a href="https://leetcode.com/problems/count-of-smaller-numbers-after-self/">https://leetcode.com/problems/count-of-smaller-numbers-after-self/</a>
 */
@Slf4j
public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        final Number[] numbers = toNumbers(nums);
        final Number[] counted = count(numbers, 0, nums.length - 1);
        return toResult(counted);
    }

    private Number[] toNumbers(int[] nums) {
        final Number[] numbers = new Number[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numbers[i] = new Number(nums[i], i);
        }

        return numbers;
    }

    private Number[] count(Number[] numbers, int from, int to) {
        if (from == to) return new Number[]{numbers[from]};

        final int mid = (from + to) / 2;
        final Number[] left = count(numbers, from, mid);
        final Number[] right = count(numbers, mid + 1, to);
        return merge(left, right, from);
    }

    private Number[] merge(Number[] left, Number[] right, int from) {
        final Number[] merged = new Number[left.length + right.length];

        int li = 0;
        int ri = 0;
        int i = 0;

        while (i < merged.length) {

            if (ri >= right.length ||
                    (li < left.length && left[li].num <= right[ri].num)) {
                // 마지막 연산자가 <= 인 것이 중복 고려에 중요한 요소
                merged[i] = left[li++];
            } else {
                merged[i] = right[ri++];
            }

            if (merged[i].index < from + i) {
                merged[i].count += from + i - merged[i].index;
            }

            merged[i].index = from + i;

            i++;
        }

        return merged;
    }

    private List<Integer> toResult(Number[] counted) {
        return Arrays
                .stream(counted)
                .sorted(Comparator.comparingInt(n -> n.originalIndex))
                .map(n -> n.count)
                .collect(Collectors.toList());
    }

    static class Number {

        final int num;
        final int originalIndex;
        int index;
        int count;

        public Number(int num, int index) {
            this.num = num;
            this.originalIndex = index;
            this.index = index;
            this.count = 0;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "num=" + num +
                    ", originalIndex=" + originalIndex +
                    ", index=" + index +
                    ", count=" + count +
                    '}';
        }
    }

}
