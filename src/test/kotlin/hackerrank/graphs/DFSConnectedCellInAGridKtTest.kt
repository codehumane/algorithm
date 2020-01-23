package hackerrank.graphs

import org.junit.Assert.assertEquals
import org.junit.Test

class DFSConnectedCellInAGridKtTest {

    @Test
    fun `maxRegion sample test case 0`() {

        // given
        val input = arrayOf(
            arrayOf(1, 1, 0, 0),
            arrayOf(0, 1, 1, 0),
            arrayOf(0, 0, 1, 0),
            arrayOf(1, 0, 0, 0)
        )

        // when
        val result = maxRegion(input)

        // then
        assertEquals(5, result)
    }

    @Test
    fun `maxRegion sample test case 1`() {

        // given
        val input = arrayOf(
            arrayOf(0, 0, 1, 1),
            arrayOf(0, 0, 1, 0),
            arrayOf(0, 1, 1, 0),
            arrayOf(0, 1, 0, 0),
            arrayOf(1, 1, 0, 0)
        )

        // when
        val result = maxRegion(input)

        // then
        assertEquals(8, result)
    }

    @Test
    fun `maxRegion sample test case 2`() {

        // given
        val input = arrayOf(
            arrayOf(1, 0, 1, 1, 0),
            arrayOf(1, 1, 0, 0, 1),
            arrayOf(0, 1, 1, 1, 0),
            arrayOf(0, 0, 0, 0, 1),
            arrayOf(1, 1, 1, 0, 0)
        )

        // when
        val result = maxRegion(input)

        // then
        assertEquals(10, result)
    }

    @Test
    fun `maxRegion 대각선도 고려해야 한다`() {

        // given
        val input = arrayOf(
            arrayOf(1, 1, 0, 0),
            arrayOf(0, 1, 1, 0),
            arrayOf(0, 0, 1, 0),
            arrayOf(1, 0, 0, 1)
        )

        // when
        val result = maxRegion(input)

        // then
        assertEquals(6, result)
    }

}