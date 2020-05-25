package hackerrank.search

import kotlin.math.max

/**
 * 부분집합이 아닌, subarray 임에 유의.
 * 중복은 고려하나 안 하나 의미 없음. (나중에 성능 개선 포인트가 될 수도)
 *
 * 만약, 결과를 캐싱한다면?
 *  - key에 필요한 공간: N + (N-1) + (N-2) + ... + 1 = (1 + N) * N / 2
 *  - 근데 이전 size에 대한 값만 유지하고 있으면 될 것으로 보임
 *  - 그리고 캐시할 때는 modulus만 기억하면 될 것
 *  - 하지만, 그럼에도 불구하고 가장 큰 소수를 생각하면, 10^18에 대한 처리는 필요 (일단 이거 고려 없이 구현 시작)
 */
fun maximumSum(a: Array<Long>, m: Long): Long {
    var result = 0L

    (1..a.size).forEach {
        result = max(result, getMaxModulus(a, it, m))
    }

    return result
}

private fun getMaxModulus(a: Array<Long>, size: Int, m: Long): Long {
    var maxModulus = 0L

    (0..a.size - size).forEach {
        var sum = 0L
        var index = it

        repeat(size) {
            sum += a[index++]
        }

        maxModulus = max(maxModulus, sum.rem(m))
    }

    return maxModulus

}
