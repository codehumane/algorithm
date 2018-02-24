package quiz

import spock.lang.Specification

class NumberOfDiscIntersectionsSpec extends Specification {

    def "solution"(int[] A, int count) {

        given:
        def intersections = new NumberOfDiscIntersections()

        expect:
        intersections.solution(A) == count

        where:
        A                  | count
        []                 | 0
        [1]                | 0
        [1, 5]             | 1
        [1, 5, 2]          | 1 + 2
        [1, 5, 2, 1]       | 1 + 2 + 2
        [1, 5, 2, 1, 4]    | 1 + 2 + 2 + 4
        [1, 5, 2, 1, 4, 0] | 1 + 2 + 2 + 4 + 2
    }
}
