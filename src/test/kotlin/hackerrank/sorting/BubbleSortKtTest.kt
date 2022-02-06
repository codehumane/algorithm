package hackerrank.sorting

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BubbleSortKtTest {

    @Test
    fun countSwaps() {
        countSwaps(arrayOf(1, 2, 3))
        countSwaps(arrayOf(3, 2, 1))
    }
}