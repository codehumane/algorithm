package quiz.etc


import spock.lang.Specification

class MaxCountersSpec extends Specification {

    def "solution"(int X, int[] A, int[] expected) {

        given:
        def counters = new MaxCounters()

        expect:
        counters.solution(X, A) == expected

        where:
        X | A                              | expected
        1 | [1]                            | [1]
        1 | [2]                            | [0]
        1 | [1, 2]                         | [1]
        2 | [1, 2]                         | [1, 1]
        2 | [1, 3]                         | [1, 1]
        2 | [3, 3]                         | [0, 0]
        2 | [1, 1]                         | [2, 0]
        2 | [1, 1, 1]                      | [3, 0]
        4 | [5, 5, 5, 5, 5]                | [0, 0, 0, 0]
        5 | [3, 4, 4, 6, 1, 4, 4]          | [3, 2, 2, 4, 2]
        6 | [1, 1, 1, 1, 1, 1, 1, 1, 1, 7] | [9, 9, 9, 9, 9, 9]
    }
}
