package quiz.sort

import quiz.sort.Distinct
import spock.lang.Specification

class DistinctSpec extends Specification {

    def "solution"(int[] A, int count) {

        given:
        def distinct = new Distinct()

        expect:
        distinct.solution(A) == count

        where:
        A                   | count
        []                  | 0
        [5]                 | 1
        [1, 1]              | 1
        [1, 2]              | 2
        [2, 1]              | 2
        [2, 4, 2]           | 2
        [-2, 0, 2]          | 3
        [2, 1, 1, 2, 3, 1]  | 3
        [-1000000, 1000000] | 2
    }

    def "mergeSort"(int[] input, int[] result) {

        given:
        def distinct = new Distinct()

        expect:
        distinct.mergeSort(input) == result

        where:
        input                    | result
        [3]                      | [3]
        [3, 2, 1]                | [1, 2, 3]
        [1, 2, 3]                | [1, 2, 3]
        [3, 1, 5, 8, 7, 6, 2, 4] | [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
