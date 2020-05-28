package hackerrank.search

import java.util.*
import kotlin.math.max

/**
 * 부분집합이 아닌, subarray 임에 유의.
 * 중복은 고려하나 안 하나 의미 없음.
 *
 * 해법은 prefix array sum을 활용해야 한다는 것.
 * 더불어 아래의 공식 활용. (어렵다)
 *  - 매번 루프를 돌며 `max(i) = (prefix(i) - prefix(x) + m) % m`를 찾는다.
 *  - 여기서 x는 최대값을 만들게 도와줄 i보다 작은 수이며,
 *  - balanced binary search tree를 통해
 *  - prefix(i)에 가장 가까우면서도 prefix(i)보다는 큰 수를 찾으면 됨.
 */
fun maximumSum(a: Array<Long>, m: Long): Long {

    val set = TreeSet<Long>()
    var pre = a[0] % m
    var res = pre
    set.add(pre)

    (1 until a.size).forEach {
        pre = (pre + a[it]) % m

        set.add(pre)
        res = max(res, pre)
        val high = set.higher(pre)
        if (high != null) res = max(res, (pre - high + m) % m)
    }

    return res
}
