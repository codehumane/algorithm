package quiz

import spock.lang.Specification

class CountFactorsSpec extends Specification {

    def "Solution"() {

        given:
        def countFactors = new CountFactors()

        expect:
        countFactors.solution(N) == count

        where:
        N          || count
        24         || 8

        1          || 1
        2          || 2
        3          || 2
        4          || 3
        5          || 2
        2147483647 || 2
    }
}
