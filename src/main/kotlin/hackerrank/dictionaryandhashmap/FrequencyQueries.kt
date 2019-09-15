package hackerrank.dictionaryandhashmap

fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val freq = mutableMapOf<Int, Int>()
    val presence = mutableMapOf<Int, Int>()
    val result = Array(queries.size) { -1 }
    var resultIndex = 0

    queries.forEach { query ->
        val operation = query[0]
        val data = query[1]

        when (operation) {
            1 -> {
                freq.putIfAbsent(data, 0)
                freq.computeIfPresent(data) { _, v -> v + 1 }
                val f = freq[data]!!
                presence.putIfAbsent(f, 0)
                presence.computeIfPresent(f) { _, v -> v + 1 }
                presence.computeIfPresent(f - 1) { _, v -> if (v > 1) v - 1 else 0 }
            }
            2 -> {
                val f: Int? = freq[data]
                if (f != null && f > 0) {
                    freq.computeIfPresent(data) { _, v -> v - 1 }
                    presence.computeIfPresent(f) { _, v -> v - 1 }
                    if (f > 1) {
                        presence.computeIfPresent(f - 1) { _, v -> v + 1 }
                    }
                }
            }
            3 -> result[resultIndex++] = if (presence[data] ?: 0 > 0) 1 else 0
        }
    }

    return result.copyOfRange(0, resultIndex)
}