package hackerrank.dictionaryandhashmap

import org.junit.Assert.assertEquals
import org.junit.Test

class CountTripletsKtTest {

    @Test
    fun `countTriplets case1`() {

        // given
        val ratio = 2L
        val arr = arrayOf<Long>(1, 2, 2, 4)
        val expectedCount = 2L

        // when
        val count = countTriplets(arr, ratio)

        // then
        assertEquals(expectedCount, count)
    }

    @Test
    fun `countTriplets case2`() {

        // given
        val ratio = 3L
        val arr = arrayOf<Long>(1, 3, 9, 9, 27, 81)
        val expectedCount = 6L

        // when
        val count = countTriplets(arr, ratio)

        // then
        assertEquals(expectedCount, count)
    }

    @Test
    fun `countTriplets case3`() {

        // given
        val ratio = 5L
        val arr = arrayOf<Long>(1, 5, 5, 25, 125)
        val expectedCount = 4L

        // when
        val count = countTriplets(arr, ratio)

        // then
        assertEquals(expectedCount, count)
    }

    @Test
    fun `countTriplets custom1 r이 1인 경우`() {

        // given
        val ratio = 1L
        val arr = arrayOf<Long>(
            1, // 0개
            2, 2, // 0개
            3, 3, 3, // 1개
            4, 4, 4, 4, // 4개 = 2+1 + 1
            5, 5, 5, 5, 5 // 10개 = 3+2+1 + 2+1 + 1
            // 그러니까, n * (n-1) * (n-2) / 3 * 2 * 1
        )
        val expectedCount = 15L

        // when
        val count = countTriplets(arr, ratio)

        // then
        assertEquals(expectedCount, count)
    }

    @Test
    fun `countTriplets custom2 100000 1`() {

        // given
        val ratio = 1L
        val arr = (0 until 100000).map { 1237L }.toTypedArray()
        val expectedCount = (100000.toDouble() * 99999.toDouble() * 99998.toDouble() / 6).toLong()

        // when
        val count = countTriplets(arr, ratio)

        // then
        assertEquals(expectedCount, count)
    }

    @Test
    fun `countTriplets custom3 i j k 순서가 꼬이지 않도록 유의`() {

        // given
        val ratio = 2L
        val arr = arrayOf<Long>(1, 2, 4, 1, 2, 1, 2, 4)
        // 1 -> cnt[1]++
        // 1,2 -> cnt[2]++, comb[2] += cnt[1]
        // 1,2,4 -> cnt[4]++, comb[4] = cnt[2], res += comb[2]
        // 1,2,4,1 -> cnt[1]++
        // 1,2,4,1,2 -> cnt[2]++, comb[2] += cnt[1]
        // 1,2,4,1,2,1 -> cnt[1]++
        // 1,2,4,1,2,1,2 -> cnt[2]++, comb[2] += cnt[1]
        // 1,2,4,1,2,1,2,4 -> cnt[4]++, comb[4] = cnt[2], res += comb[2]
        val expectedCount = 7L

        // when
        val count = countTriplets(arr, ratio)

        // then
        assertEquals(expectedCount, count)
    }

    @Test
    fun `countTriplets custom3 i j k 순서가 꼬이지 않도록 유의 두 번째`() {

        // given
        val ratio = 2L
        val arr = arrayOf<Long>(1, 2, 4, 1, 2, 1, 2, 4, 8)
        val expectedCount = 7L + 4L

        // when
        val count = countTriplets(arr, ratio)

        // then
        assertEquals(expectedCount, count)
    }

}