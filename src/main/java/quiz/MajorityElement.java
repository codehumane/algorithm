package quiz;

/**
 * Given an array nums of size n, return the majority element.<br/>
 * <br/>
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.<br/>
 * <br/>
 * Constraints:<br/>
 * <br/>
 * - n == nums.length<br/>
 * - 1 <= n <= 5 * 104<br/>
 * - -231 <= nums[i] <= 231 - 1<br/>
 * <br/>
 * Follow-up: Could you solve the problem in linear time and in O(1) space?<br/>
 * <br/>
 * <a href="https://leetcode.com/problems/majority-element/">https://leetcode.com/problems/majority-element/</a>
 */
public class MajorityElement {

    private final BruteForceMajorityElement bruteForce = new BruteForceMajorityElement();

    public int majorityElement(int[] nums) {
        return bruteForce.solve(nums);
    }

    /**
     * brute force 풀이
     * <p>
     * 시간 복잡도: O(n^2)
     * 공간 복잡도: O(1)
     */
    static class BruteForceMajorityElement {

        public int solve(int[] nums) {
            final int majority = nums.length / 2;

            for (int candidate : nums) {
                int appearance = 0;

                for (int num : nums) {
                    if (num == candidate) appearance++;
                    if (appearance >= majority) return candidate;
                }
            }

            throw new IllegalStateException();
        }

    }

}
