package hackerrank.dictionaryandhashmap

fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val result = Array<Int>(queries.size) { -1 }
    val freq = mutableMapOf<Int, Int>()

    queries.forEach { query ->
        val operation = query[0]
        val data = query[1]

        freq.putIfAbsent(data, 0)

        when (operation) {
            1 -> freq.computeIfPresent(data) { _, v -> v + 1 }
            2 -> freq.computeIfPresent(data) { _, v -> if (v > 0) v - 1 else v }
            3 -> result[result.indexOf(-1)] = if (freq.any { it.value == data }) 1 else 0
        }
    }

    return result.copyOfRange(0, result.indexOf(-1))
}