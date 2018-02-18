package quiz

import spock.lang.Specification

class MinAvgTwoSliceSpec extends Specification {

    def "solution"(int[] input, int startIndexOfMinAverage) {

        given:
        def slice = new MinAvgTwoSlice()

        expect:
        slice.solution(input) == startIndexOfMinAverage

        where:
        input                 | startIndexOfMinAverage
        [3, 3]                | 0
        [3, 3, 9]             | 0
        [3, 3, 9, 1]          | 0
        [3, 3, 9, 1, 6]       | 0
        [3, 3, 9, 1, 6, 1]    | 3
        [3, 3, 9, 1, 6, 1, 6] | 3
        [4, 2, 2, 5, 1, 5, 8] | 1
    }
}
