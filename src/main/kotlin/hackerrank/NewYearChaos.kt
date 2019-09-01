package hackerrank

/**
 * 발견한 규칙은 2개.
 *
 * 1. 앞으로는 최대 2번 밖에 올 수 없음.
 * 2. 뒤로는 얼마든지 갈 수 있음.
 *
 * 따라서, 뒷 숫자부터 시작해서, 앞으로 간 숫자를 발견하면, 다시 원래 자리인 뒤로 옮긴다.
 * 앞으로 간 숫자를 발견했는데, 2개를 초과하여 앞으로 이동한 경우라면, Too chaotic 케이스!
 */
fun countMinimumBribes(q: Array<Int>): Int {
    var count = 0

    (q.size - 2 downTo 0).forEach { index ->
        while (q[index] - (index + 1) > 0) {
            val diff = q[index] - (index + 1)
            check(diff <= 2)

            (1..diff).forEach {
                swap(q, index + it - 1, index + it)
                count++
            }
        }
    }

    return count
}

private fun swap(arr: Array<Int>, idx1: Int, idx2: Int) {
    val temp = arr[idx1]
    arr[idx1] = arr[idx2]
    arr[idx2] = temp
}
