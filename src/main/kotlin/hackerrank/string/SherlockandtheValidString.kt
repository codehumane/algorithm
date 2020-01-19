package hackerrank.string

fun isValid(s: String): String {

    val frequencyToCount = s    // a, a, b, c, c
        .groupBy { it }         // {a: [a,a], b: [b], c: [c]}
        .map { it.value.size }  // [2, 1, 2]
        .groupingBy { it }      // {2: [2,2], 1: [1]}
        .eachCount()            // {2: 2, 1: 1}

    // 출현 빈도가 모두 동일하면 참
    if (frequencyToCount.size <= 1) return "YES"

    // 출현 빈도의 종류가 2개가 존재할 때,
    if (frequencyToCount.size == 2) {
        val frequencies = frequencyToCount.keys.toList()
        // 출현 빈도가 다른 것이 1개 있고, 이 출현빈도의 문자가 1개뿐이라면 참.
        if (frequencyToCount.any { it.value == 1 && it.key == 1 }) return "YES"
        // 또는, 출현 빈도가 다른 1개를 -1 했을 때, 나머지 출현 빈도와 값이 갔다면 참
        if (frequencyToCount[frequencies[0]] == 1 && frequencies[0] - 1 == frequencies[1]) return "YES"
        if (frequencyToCount[frequencies[1]] == 1 && frequencies[1] - 1 == frequencies[0]) return "YES"
    }

    return "NO"
}