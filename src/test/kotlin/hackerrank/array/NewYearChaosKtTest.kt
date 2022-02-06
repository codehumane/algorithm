package hackerrank.array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class NewYearChaosKtTest {

    @Test
    fun `minimumBribes case1`() {

        // 2 1 5 3 4
        // 2 1 3 5 4
        // 2 1 3 4 5
        // 1 2 3 4 5

        val input = arrayOf(2, 1, 5, 3, 4)
        val count = countMinimumBribes(input)
        assertEquals(3, count)
    }

    @Test
    fun `minimumBribes case2`() {
        assertThrows(IllegalStateException::class.java) {
            val input = arrayOf(2, 5, 1, 3, 4)
            countMinimumBribes(input)
        }
    }

    @Test
    fun `minimumBribes case3`() {
        assertThrows(IllegalStateException::class.java) {
            val input = arrayOf(5, 1, 2, 3, 7, 8, 6, 4)
            countMinimumBribes(input)
        }
    }

    @Test
    fun `minimumBribes case4`() {

        // 1 2 5 3 7 8 6 4
        // 1 2 5 3 7 6 8 4
        // 1 2 5 3 7 6 4 8
        // 1 2 5 3 6 7 4 8
        // 1 2 5 3 6 4 7 8
        // 1 2 5 3 4 6 7 8
        // 1 2 3 5 4 6 7 8
        // 1 2 3 4 5 6 7 8

        val input = arrayOf(1, 2, 5, 3, 7, 8, 6, 4)
        val count = countMinimumBribes(input)
        assertEquals(7, count)
    }

    @Test
    fun `minimumBribes case custom1`() {

        // 3 2 1 4 5
        // 2 3 1 4 5
        // 2 1 3 4 5
        // 1 2 3 4 5

        val input = arrayOf(3, 2, 1, 4, 5)
        val count = countMinimumBribes(input)
        assertEquals(3, count)
    }

}