package quiz.tree;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given two arrays,
 * write a function to compute their intersection.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        final int[] result = new int[nums1.length];
        int[] shorter = nums1.length > nums2.length ? nums2 : nums1;
        int[] longer = nums1.length > nums2.length ? nums1 : nums2;

        Arrays.sort(longer);

        final Set<Integer> shorterNums = Arrays
                .stream(shorter)
                .boxed()
                .collect(Collectors.toSet());

        int index = 0;
        for (Integer num : shorterNums) {
            if (Arrays.binarySearch(longer, num) >= 0) {
                result[index++] = num;
            }
        }

        return Arrays.copyOf(result, index);
    }

}
