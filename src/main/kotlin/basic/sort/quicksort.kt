package basic.sort

/**
 * pivot과 partition을 기억하면 될 듯.
 * 아래 그림을 기반으로, 오랜만에 구현.
 *
 * https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Quicksort-diagram.svg/400px-Quicksort-diagram.svg.png
 *
 * 그림 예시 값은 아래와 같음.
 * [3, 7, 8, 5, 2, 1, 9, 5, 4]
 * [3, 5, 8, 5, 2, 1, 9, 4, 7]
 * [3, 9, 8, 5, 2, 1, 4, 5, 7]
 * [3, 1, 8, 5, 2, 4, 9, 5, 7]
 * [3, 1, 2, 5, 4, 8, 9, 5, 7]
 * [3, 1, 2, 4, 5, 8, 9, 5, 7]
 * [3, 1, 2] [4, 5, 8, 9, 5, 7]
 * [1, 2, 3] 4 [5, 8, 9, 5, 7]
 * [1], 2, [3], 4, [5, 8, 9, 5, 7]
 * 1, 2, 3, 4, [5, 8, 9, 5, 7]
 * 1, 2, 3, 4, [5, 5, 9, 7, 8]
 * 1, 2, 3, 4, [5, 5, 7, 9, 8]
 * 1, 2, 3, 4, [5, 5], 7, [9, 8]
 * 1, 2, 3, 4, [5], [5], 7, [9, 8]
 * 1, 2, 3, 4, 5, 5, 7, [9, 8]
 * 1, 2, 3, 4, 5, 5, 7, [8, 9]
 * 1, 2, 3, 4, 5, 5, 7, [8], [9]
 * 1, 2, 3, 4, 5, 5, 7, 8, 9
 *
 */
fun quickSort(array: Array<Int>) {
    quickSort(array, 0, array.lastIndex)
}

private fun quickSort(array: Array<Int>, startIndex: Int, endIndex: Int) {
    val pivotIndex = partition(array, startIndex, endIndex)

    if (pivotIndex > 0) {
        quickSort(array, startIndex, pivotIndex)
        quickSort(array, pivotIndex + 2, endIndex) // pivotIndex + 1은 정렬이 무의미
    }
}

/**
 * 예시
 *
 * 1,5,4,3,2 (원본)
 * 1,5,4,3,2 (1: 그대로)
 * 1,3,4,2,5 (2: 순환)
 * 1,4,2,3,5 (3: 순환)
 * 1,2,4,3,5 (4: 순환-앞뒤로만)
 * -> pivot = 2 (index = 1)
 */
private fun partition(array: Array<Int>, startIndex: Int, endIndex: Int): Int {
    if (endIndex - startIndex < 1) return -1

    var left = startIndex
    var right = endIndex

    while (left < right) {
        if (array[left] > array[right]) {
            swap(array, left, right)

            if (right - left > 1)
                swap(array, left, right - 1)

            right--
        } else {
            left++
        }
    }

    return right - 1
}

private fun swap(array: Array<Int>, i1: Int, i2: Int) {
    val temp = array[i1]
    array[i1] = array[i2]
    array[i2] = temp
}