package hackerrank.sorting

/**
 *        21312
 *        /   \
 *      213    12
 *      / \    / \
 *    21   3  1   2
 *   / \   |  |   |
 *  2   1  3  1   2
 *  \  /   |   \ /
 *   12    3   12
 *    \   /    |
 *     123     12
 *       \    /
 *       11223
 */
fun countInversions(arr: Array<Int>): Long {
    val count = Count()
    sort(arr, 0, arr.size - 1, count)
    return count.get()
}

private fun sort(arr: Array<Int>, start: Int, end: Int, count: Count) {
    if (start >= end) return

    val mid = (start + end).div(2)
    sort(arr, start, mid, count)
    sort(arr, mid + 1, end, count)
    merge(arr, start, mid, end, count)
}

private fun merge(arr: Array<Int>, start: Int, mid: Int, end: Int, count: Count) {

    var lIdx = 0
    var rIdx = 0
    val left = arr.copyOfRange(start, mid + 1)
    val right = arr.copyOfRange(mid + 1, end + 1)

    (start..end).forEach {
        if (lIdx >= left.size) {
            arr[it] = right[rIdx++]

        } else if (rIdx < right.size && right[rIdx] < left[lIdx]) {
            arr[it] = right[rIdx++]
            count.increment(left.size - lIdx)

        } else {
            arr[it] = left[lIdx++]
        }
    }
}

data class Count(private var value: Long) {
    constructor() : this(0)

    fun get() = value

    fun increment(diff: Int) {
        value += diff
    }
}