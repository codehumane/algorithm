package hackerrank

fun minimumSwaps(arr: Array<Int>): Int {
    var count = 0

    (0 until arr.size - 1)
        .forEach {
            while (arr[it] != it + 1) {
                swap(arr, it, arr[it] - 1)
                count++
            }
        }

    return count
}

private fun swap(arr: Array<Int>, idx1: Int, idx2: Int) {
    val temp = arr[idx1]
    arr[idx1] = arr[idx2]
    arr[idx2] = temp
}
