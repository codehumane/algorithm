package hackerrank

fun minimumSwaps(arr: Array<Int>): Int {
    return (1..arr.size)
        .map { placeValueAt(arr, it, it - 1) }
        .count { it }
}

fun placeValueAt(arr: Array<Int>, value: Int, at: Int): Boolean {
    val valueIndex = arr.indexOf(value)
    if (valueIndex == at) return false
    swap(arr, valueIndex, at)
    return true
}

fun swap(arr: Array<Int>, idx1: Int, idx2: Int) {
    val temp = arr[idx1]
    arr[idx1] = arr[idx2]
    arr[idx2] = temp
}
