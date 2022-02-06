package hackerrank.dictionaryandhashmap

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FrequencyQueriesKtTest {

    @Test
    fun `freqQuery case1`() {

        // given
        val queries = arrayOf(
            arrayOf(1, 1),
            arrayOf(2, 2),
            arrayOf(3, 2),
            arrayOf(1, 1),
            arrayOf(1, 1),
            arrayOf(2, 1),
            arrayOf(3, 2)
        )

        // when
        val result = freqQuery(queries)

        // then
        assertArrayEquals(arrayOf(0, 1), result)
    }

    @Test
    fun `freqQuery case2`() {

        // given
        val queries = arrayOf(
            arrayOf(1, 5),
            arrayOf(1, 6),
            arrayOf(3, 2),
            arrayOf(1, 10),
            arrayOf(1, 10),
            arrayOf(1, 6),
            arrayOf(2, 5),
            arrayOf(3, 2)
        )

        // when
        val result = freqQuery(queries)

        // then
        assertArrayEquals(arrayOf(0, 1), result)
    }

    @Test
    fun `freqQuery case3`() {

        // given
        val queries = arrayOf(
            arrayOf(3, 4),
            arrayOf(2, 1003),
            arrayOf(1, 16),
            arrayOf(3, 1)
        )

        // when
        val result = freqQuery(queries)

        // then
        assertArrayEquals(arrayOf(0, 1), result)
    }

    @Test
    fun `freqQuery case4`() {

        // given
        val queries = arrayOf(
            arrayOf(1, 3),
            arrayOf(2, 3),
            arrayOf(3, 2),
            arrayOf(1, 4),
            arrayOf(1, 5),
            arrayOf(1, 5),
            arrayOf(1, 4),
            arrayOf(3, 2),
            arrayOf(2, 4),
            arrayOf(3, 2)
        )

        // when
        val result = freqQuery(queries)

        // then
        assertArrayEquals(arrayOf(0, 1, 1), result)
    }
}