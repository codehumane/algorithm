package quiz

import spock.lang.Specification

class CountDivSpec extends Specification {

    def "Solution"() {

        given:
        def div = new CountDiv()

        expect:
        div.solution(A, B, K) == count

        where:
        A | B  | K || count
        6 | 11 | 2 || 3

        2 | 2  | 3 || 0
        3 | 3  | 3 || 1
        4 | 4  | 3 || 0
        5 | 5  | 3 || 0

        2 | 3  | 3 || 1
        2 | 4  | 3 || 1
        3 | 4  | 3 || 1
        3 | 5  | 3 || 1
        3 | 6  | 3 || 2
        3 | 7  | 3 || 2
    }
}
