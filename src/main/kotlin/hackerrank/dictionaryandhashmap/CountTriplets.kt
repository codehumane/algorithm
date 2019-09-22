package hackerrank.dictionaryandhashmap

/**
 * dictionary 임을 미리 생각해 보지 않으면 어려울 수도.
 *
 * [풀이: 아래 케이스를 일반화 함]
 *
 * 1 -> cnt[1]++
 * 1,2 -> cnt[2]++, comb[2] += cnt[1]
 * 1,2,4 -> cnt[4]++, comb[4] = cnt[2], res += comb[2]
 * 1,2,4,1 -> cnt[1]++
 * 1,2,4,1,2 -> cnt[2]++, comb[2] += cnt[1]
 * 1,2,4,1,2,1 -> cnt[1]++
 * 1,2,4,1,2,1,2 -> cnt[2]++, comb[2] += cnt[1]
 * 1,2,4,1,2,1,2,4 -> cnt[4]++, comb[4] = cnt[2], res += comb[2]
 */
fun countTriplets(arr: Array<Long>, r: Long): Long {

    if (r == 1L) {
        return arr
            .groupingBy { it }
            .eachCount()
            .values
            .map { it.toLong() }
            .map { it * (it - 1) * (it - 2) / 6L }
            .sum()

    }

    var total = 0L
    val occurs = mutableMapOf<Long, Long>()
    val combs = mutableMapOf<Long, Long>()

    arr.forEach {
        occurs[it] = occurs.getOrDefault(it, 0) + 1

        if (it % r == 0L) {
            combs[it] = combs.getOrDefault(it, 0) + occurs.getOrDefault(it / r, 0)
            combs[it / r]?.let { c -> total += c }
        }
    }

    return total

}
