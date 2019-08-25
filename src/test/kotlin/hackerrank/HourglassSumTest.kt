package hackerrank

import org.junit.Assert.assertEquals
import org.junit.Test

class HourglassSumTest {

    @Test
    fun hourglassSum() {
        val sum = HourglassSum()

        // given
        val input1 = arrayOf(
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 1, 0, 0, 0, 0),
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 0, 2, 4, 4, 0),
            arrayOf(0, 0, 0, 2, 0, 0),
            arrayOf(0, 0, 1, 2, 4, 0)
        )

        val input2 = arrayOf(
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 1, 0, 0, 0, 0),
            arrayOf(1, 1, 1, 0, 0, 0),
            arrayOf(0, 9, 2, -4, -4, 0),
            arrayOf(0, 0, 0, -2, 0, 0),
            arrayOf(0, 0, -1, -2, -4, 0)
        )

        val input3 = arrayOf(
            arrayOf(-9, -9, -9, 1, 1, 1),
            arrayOf(0, -9, 0, 4, 3, 2),
            arrayOf(-9, -9, -9, 1, 2, 3),
            arrayOf(0, 0, 8, 6, 6, 0),
            arrayOf(0, 0, 0, -2, 0, 0),
            arrayOf(0, 0, 1, 2, 4, 0)
        )

        assertEquals(19, sum.hourglassSum(input1))
        assertEquals(13, sum.hourglassSum(input2))
        assertEquals(28, sum.hourglassSum(input3))
    }
}