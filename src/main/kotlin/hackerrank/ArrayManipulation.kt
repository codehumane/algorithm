package hackerrank

import kotlin.math.max

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val array = Array(n, init = { 0L })
    var maxValue = Long.MIN_VALUE

    queries.forEach { query ->

        val fromInclusive = query[0] - 1
        val toInclusive = query[1] - 1
        val addAmount = query[2]

        (fromInclusive..toInclusive).forEach { index ->
            array[index] = array[index] + addAmount
            maxValue = max(array[index], maxValue)
        }
    }

    return maxValue
}
