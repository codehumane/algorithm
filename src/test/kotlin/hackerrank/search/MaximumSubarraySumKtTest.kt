package hackerrank.search

import org.junit.Assert.assertEquals
import org.junit.Test

class MaximumSubarraySumKtTest {

    @Test
    fun maximumSum() {
        assertEquals(1, maximumSum(arrayOf(1, 2, 3, 4), 2))
        assertEquals(1, maximumSum(arrayOf(1, 2, 3), 2))
        assertEquals(4, maximumSum(arrayOf(1, 5, 9), 5))
        assertEquals(6, maximumSum(arrayOf(3, 3, 9, 9, 5), 7))

    }

}
