package hackerrank.array

import hackerrank.array.HourglassSum
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HourglassSumTest {

    private val solution = HourglassSum()

    @Test
    fun `hourglassSum case1`() {
        val input = arrayOf(
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 1, 0, 0, 0, 0),
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 0, 2, 4, 4, 0),
            arrayOf(0, 0, 0, 2, 0, 0),
            arrayOf(0, 0, 1, 2, 4, 0)
        )

        val result = solution.hourglassSum(input)
        assertEquals(19, result)
    }

    @Test
    fun `hourglassSum case2`() {
        val input = arrayOf(
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 1, 0, 0, 0, 0),
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 9, 2, -4, -4, 0),
            arrayOf(0, 0, 0, -2, 0, 0),
            arrayOf(0, 0, -1, -2, -4, 0)
        )

        val result = solution.hourglassSum(input)
        assertEquals(13, result)
    }

    @Test
    fun `hourglassSum case3`() {
        val input = arrayOf(
            arrayOf(-9, -9, -9, 1, 1, 1),
            arrayOf(0, -9, 0, 4, 3, 2),
            arrayOf(-9, -9, -9, 1, 2, 3),
            arrayOf(0, 0, 8, 6, 6, 0),
            arrayOf(0, 0, 0, -2, 0, 0),
            arrayOf(0, 0, 1, 2, 4, 0)
        )

        val result = solution.hourglassSum(input)
        assertEquals(28, result)
    }
}