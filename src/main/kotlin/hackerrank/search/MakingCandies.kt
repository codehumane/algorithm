package hackerrank.search

import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.min

/**
 * 5,1 10 15
 *
 * 시나리오1.
 * 1> 5x1 = 5
 * 2> 5 + 5x1 = 10 (여기서 분기! 구입 없이 현재 production capacity로 1 pass만 더 하면 끝난다는 게 보장되면 구입을 멈춘다)
 * 3> 10 + 5x1 = 15
 *
 * 시나리오2.
 * 1> 5x1 = 5
 * 2> (5 + 5x1 = 10) - 1x10 = 0
 * 3> 0 + 5x2 = 10
 * 4> 10 + 5x2 = 20
 */
fun minimumPasses(m: Long, w: Long, p: Long, n: Long): Long {

    var accumulation = 0L
    var machines = m
    var workers = w
    var pass = 0L
    var optimizedPass = Long.MAX_VALUE

    while (accumulation < n) {

        pass++

        if (accumulation >= p) {
            val purchase = accumulation.div(p)
            accumulation = accumulation.rem(p)

            val total = purchase + machines + workers
            val half = total.div(2)
            if (machines > workers) {
                machines = max(machines, half)
                workers = total - machines
            } else {
                workers = max(workers, half)
                machines = total - workers
            }
        }

        val production = try {
            Math.multiplyExact(machines, workers)
        } catch (e: ArithmeticException) {
            break
        }

        accumulation = try {
            Math.addExact(accumulation, production)
        } catch (e: ArithmeticException) {
            break
        }

        optimizedPass = min(
            optimizedPass,
            pass + ceil((n - accumulation).div(production.toDouble())).toLong()
        )
    }

    return min(pass, optimizedPass)
}
