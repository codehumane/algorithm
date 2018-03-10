package quiz

import spock.lang.Specification

class MaxSliceSumSpec extends Specification {

    def "Solution"(int[] A, int max) {

        given:
        def sum = new MaxSliceSum()

        expect:
        sum.solution(A) == max

        where:
        A                    | max
        [3, 2, -6, 4, 0]     | 5

        [3]                  | 3
        [3, 2]               | 5

        [3, 2, -2]           | 5
        [3, 2, -2, 1]        | 5
        [3, 2, -2, 2]        | 5
        [3, 2, -2, 3]        | 6

        [7, -2, 2, 1, -3, 4] | 9
        [7, -2, 3, -3, 4]    | 9
        [2, -3, 7, 4, -2, 1] | 11
        [2, -3, 11, -2, 1]  || 11
        [2, -3, 5, -2, 7]   || 10

        [-1, -2, 4]          | 4
        [-2, -1, -3]         | -1
    }
}
