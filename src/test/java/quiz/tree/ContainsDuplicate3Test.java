package quiz.tree;

import org.junit.jupiter.api.Test;
import quiz.tree.ContainsDuplicate3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicate3Test {

    private final ContainsDuplicate3 duplicate = new ContainsDuplicate3();

    @Test
    public void example1() {
        final int[] nums = {1, 2, 3, 1};
        final int k = 3;
        final int t = 0;

        assertTrue(duplicate.containsNearbyAlmostDuplicate(nums, k, t));
    }

    @Test
    public void example2() {
        final int[] nums = {1, 0, 1, 1};
        final int k = 1;
        final int t = 2;

        assertTrue(duplicate.containsNearbyAlmostDuplicate(nums, k, t));
    }

    @Test
    public void example3() {
        final int[] nums = {1, 5, 9, 1, 5, 9};
        final int k = 2;
        final int t = 3;

        assertFalse(duplicate.containsNearbyAlmostDuplicate(nums, k, t));
    }

    @Test
    public void failed1_signed_int의_가장_큰_숫자가_주어진_경우를_고려해야_한다() {
        final int[] nums = {-2147483648, 2147483647};
        final int k = 1;
        final int t = 1;

        assertFalse(duplicate.containsNearbyAlmostDuplicate(nums, k, t));
    }

    @Test
    public void failed2_몫을_활용한_구현이라면_t가_0인_경우도_고려해야_한다() {
        final int[] nums = {1, 2, 3, 1};
        final int k = 3;
        final int t = 0;

        assertTrue(duplicate.containsNearbyAlmostDuplicate(nums, k, t));
    }

    @Test
    public void failed3() {
        final int[] nums = {2147483646, 2147483647};
        final int k = 3;
        final int t = 3;

        assertTrue(duplicate.containsNearbyAlmostDuplicate(nums, k, t));
    }
}