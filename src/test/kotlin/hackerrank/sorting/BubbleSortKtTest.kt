package hackerrank.sorting

import org.junit.Test

import org.junit.Assert.*

class BubbleSortKtTest {

    @Test
    fun countSwaps() {
        countSwaps(arrayOf(1, 2, 3))
        countSwaps(arrayOf(3, 2, 1))
    }
}