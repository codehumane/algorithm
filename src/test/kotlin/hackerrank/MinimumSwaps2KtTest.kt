package hackerrank

import org.junit.Assert.assertEquals
import org.junit.Test

class MinimumSwaps2KtTest {

    @Test
    fun `minimumSwaps case 1`() {
        val input = arrayOf(7, 1, 3, 2, 4, 5, 6)
        val count = minimumSwaps(input)
        assertEquals(5, count)
    }

    @Test
    fun `minimumSwaps case 2`() {
        val input = arrayOf(4, 3, 1, 2)
        val count = minimumSwaps(input)
        assertEquals(3, count)
    }

    @Test
    fun `minimumSwaps case 3`() {
        val input = arrayOf(2, 3, 4, 1, 5)
        val count = minimumSwaps(input)
        assertEquals(3, count)
    }

    @Test
    fun `minimumSwaps case 4`() {
        val input = arrayOf(1, 3, 5, 2, 4, 6, 7)
        val count = minimumSwaps(input)
        assertEquals(3, count)
    }

}