package quiz.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        Arrays.fill(result, 1);

        var prefix = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] *= prefix;
            prefix *= nums[i];
        }

        var suffix = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }

}
