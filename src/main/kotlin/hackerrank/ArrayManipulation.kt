package hackerrank

import kotlin.math.max

/**
 * 성능 개선에는 시작점과 끝점에만 관심을 두도록,
 * (그러니까 query 안에 있는 범위를 모두 순회하지 않고, 범위의 시작과 끝 값에만 관심을 가짐)
 * 누적합을 이용한다.
 */
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val array = LongArray(n)

    queries.forEach { query ->

        val from = query[0] - 1
        val to = query[1] - 1
        val increment = query[2]

        array[from] = array[from] + increment
        if (to < array.size - 1) array[to + 1] = array[to + 1] - increment
    }

    var sum = 0L
    var maxValue = 0L
    (0 until array.size).forEach { index ->
        sum += array[index]
        array[index] = sum
        maxValue = max(maxValue, array[index])
    }

    return maxValue
}
