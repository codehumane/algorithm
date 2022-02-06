package hackerrank.sorting

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeSortCountingInversionsKtTest {

    @Test
    fun countInversions() {
        assertEquals(0, countInversions(arrayOf(1, 1, 1, 2, 2)))
        assertEquals(4, countInversions(arrayOf(2, 1, 3, 1, 2)))
    }

}
