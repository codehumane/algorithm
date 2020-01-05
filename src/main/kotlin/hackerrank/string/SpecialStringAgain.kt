package hackerrank.string

import kotlin.math.min

fun substrCount(n: Int, s: String): Long {

    var count = n.toLong()
    val serial = arrayOfNulls<Char>(n)
    var last = -1

    s.forEachIndexed { idx, char ->
        if (last >= 0 && serial[last] != char) {
            count += countComposition(last + 1)
            count += countMidException(idx, last, s, serial[last]!!)
            last = -1
        }

        serial[++last] = char
        if (idx == s.length - 1)
            count += countComposition(last + 1)
    }

    return count
}

private fun countMidException(
    idx: Int,
    last: Int,
    s: String, // 최초에 주어진 s
    char: Char
): Int {

    var count = 0
    val startIdx = idx + 1
    if (startIdx >= s.length) return 0
    val endIdx = min(idx + last + 1, s.length - 1)

    (startIdx..endIdx).forEach {
        if (s[it] == char) count++
        else return count
    }

    return count
}

/**
 * a -> 0
 * aa -> 1
 * aaa -> 2 + 1
 * aaaa -> 3 + 2 + 1
 * ...
 * a가 n개 -> n(n - 1) / 2
 */
fun countComposition(elementCount: Int): Long = elementCount.toLong().let { it * (it - 1) / 2 }
