package quiz

import spock.lang.Specification

class GenomicRangeQuerySpec extends Specification {

    def "solution"(String S, int[] P, int[] Q, int[] result) {

        given:
        def query = new GenomicRangeQuery()

        expect:
        query.solution(S, P, Q) == result

        where:
        S         | P         | Q         | result
        "CAGCCTA" | [2, 5, 0] | [4, 5, 6] | [2, 4, 1]
        "C"       | [0]       | [0]       | [2]
        "CA"      | [0, 1]    | [1, 1]    | [1, 1]
        "CC"      | [0, 1]    | [1, 1]    | [2, 2]
    }
}
