package quiz.tree;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.<br/>
 * There is only one repeated number in nums, return this repeated number.
 * <br/><br/>
 * Constraints:
 * <br/><br/>
 * - 2 <= n <= 3 * 104<br/>
 * - nums.length == n + 1<br/>
 * - 1 <= nums[i] <= n<br/>
 * - All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * <br/><br/>
 * Follow up:
 * <br/><br/>
 * - How can we prove that at least one duplicate number must exist in nums?<br/>
 * - Can you solve the problem without modifying the array nums?<br/>
 * - Can you solve the problem using only constant, O(1) extra space?<br/>
 * - Can you solve the problem with runtime complexity less than O(n2)?<br/>
 *
 * @see <a href="https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1039">https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1039/</a>
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];

        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }

}
