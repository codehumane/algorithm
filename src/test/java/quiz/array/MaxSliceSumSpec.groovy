package quiz.array

import quiz.array.MaxSliceSum
import spock.lang.Specification

class MaxSliceSumSpec extends Specification {

    def "Solution"(int[] A, int max) {

        given:
        def sum = new MaxSliceSum()

        expect:
        sum.solution(A) == max

        where:
        A                 | max
        [3, 2, -6, 4, 0]  | 5

        [3]               | 3

        [3, -1, 2]        | 4
        [3, -1, 4]        | 6

        [3, -1, 4, -5]    | 6
        [3, -1, 4, -5, 7] | 8
        [3, -1, 4, -6, 7] | 7
        [3, -1, 4, -7, 7] | 7
    }
}
