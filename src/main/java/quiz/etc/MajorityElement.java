package quiz.etc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    private final HashMapMajorityElement hashMap = new HashMapMajorityElement();
    private final SortMajorityElement sort = new SortMajorityElement();
    private final BoyerMooreVotingMajorityElement voting = new BoyerMooreVotingMajorityElement();
    private final MergeMajorityElement merge = new MergeMajorityElement();

    public int majorityElement(int[] nums) {
        final int result1 = hashMap.solve(nums);
        final int result2 = bruteForce.solve(nums);
        final int result3 = sort.solve(nums);
        final int result4 = voting.solve(nums);
        final int result5 = merge.solve(nums);

        assert result1 == result2;
        assert result1 == result3;
        assert result1 == result4;
        assert result1 == result5;
        return result1;
    }

    /**
     * brute force 풀이
     * <p>
     * 시간 복잡도: O(n^2)
     * 공간 복잡도: O(1)
     */
    static class BruteForceMajorityElement {

        public int solve(int[] nums) {
            final int majority = nums.length / 2 + 1;

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

    /**
     * hashmap 풀이
     * <p>
     * 시간 복잡도: O(n)
     * 공간 복잡도: O(n)
     */
    static class HashMapMajorityElement {

        public int solve(int[] nums) {
            final Map<Integer, Integer> appearance = new HashMap<>();

            for (int num : nums) {
                appearance.putIfAbsent(num, 0);
                appearance.computeIfPresent(num, (k, v) -> v + 1);
            }

            return appearance
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElseThrow(IllegalStateException::new);
        }

    }

    /**
     * 정렬 활용 (절반이 넘는 수이기 때문에 정렬 후 가운데 값을 고르는 것만으로 충분)
     * <p>
     * 시간 복잡도: O(n * log n)
     * 공간 복잡도: O(n) - 물론 입력값을 훼손해도 된다면 O(1)
     */
    static class SortMajorityElement {

        public int solve(int[] nums) {
            final int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted);
            return sorted[nums.length / 2];
        }

    }

    /**
     * Boyer Moore의 투표 알고리즘이라고 함.
     * <p>
     * 시간 복잡도: O(n)
     * 공간 복잡도: n
     */
    static class BoyerMooreVotingMajorityElement {

        public int solve(int[] nums) {
            if (nums.length == 0) {
                throw new IllegalArgumentException();
            }

            int candidate = nums[0];
            int count = 1;

            for (int i = 1; i < nums.length; i++) {
                if (count == 0) candidate = nums[i];
                if (nums[i] == candidate) count++;
                else count--;
            }

            return candidate;
        }

    }

    /**
     * 병합(divide and conquer) 활용
     *
     * 시간복잡도: O(n * log n)
     * 공간복잡도: O(log n)
     */
    static class MergeMajorityElement {

        public int solve(int[] nums) {
            return solve(nums, 0, nums.length - 1);
        }

        private int solve(int[] nums, int from, int to) {

            // 기저 조건
            if (from == to) return nums[from];

            // 쪼개어 수행
            final int mid = (from + to) / 2;
            final int left = solve(nums, from, mid);
            final int right = solve(nums, mid + 1, to);

            // 나온 결과 2개 중 누가 정말 더 큰 숫자를 갖고 있는지 검사
            final int leftCount = count(left, nums, from, to);
            final int rightCount = count(right, nums, from, to);
            return leftCount > rightCount ? left : right;
        }

        private int count(int target, int[] nums, int from, int to) {
            int count = 0;

            for (int i = from; i <= to; i++) {
                if (nums[i] == target) count++;
            }

            return count;
        }

    }

}
