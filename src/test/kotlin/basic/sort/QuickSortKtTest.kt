package basic.sort

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class QuickSortKtTest {

    @Test
    fun quickSort() {

        // given
        val source = arrayOf(3, 7, 8, 5, 2, 1, 9, 5, 4)
        val expected = arrayOf(1, 2, 3, 4, 5, 5, 7, 8, 9)

        // when
        quickSort(source)

        // then
        assertArrayEquals(expected, source)
    }

}