package hackerrank.array

import kotlin.math.max

/**
 * 2D Array - DS (Hourglass Sum)
 */
class HourglassSum {

    fun hourglassSum(arr: Array<Array<Int>>): Int {
        val maxLineIndex = arr.size - 2
        val maxSpaceIndex = arr[0].size - 2
        var maxSum = Integer.MIN_VALUE

        (0 until maxLineIndex).forEach { lineIdx ->
            (0 until maxSpaceIndex).forEach { spaceIdx ->
                maxSum = max(maxSum, sumHourglass(arr, lineIdx, spaceIdx))
            }
        }

        return maxSum
    }

    private fun sumHourglass(arr: Array<Array<Int>>, lineIdx: Int, spaceIdx: Int): Int {
        return arr[lineIdx][spaceIdx] +
                arr[lineIdx][spaceIdx + 1] +
                arr[lineIdx][spaceIdx + 2] +
                arr[lineIdx + 1][spaceIdx + 1] +
                arr[lineIdx + 2][spaceIdx] +
                arr[lineIdx + 2][spaceIdx + 1] +
                arr[lineIdx + 2][spaceIdx + 2]
    }

}