package hackerrank.search

fun whatFlavors(cost: Array<Int>, money: Int): Pair<Int, Int> {
    val indices = mutableMapOf<Int, Int>()

    cost.forEachIndexed { i, c ->
        if (indices.containsKey(money - c)) {
            return indices[money - c]!! + 1 to i + 1
        }

        indices[c] = i
    }

    throw IllegalStateException()
}
