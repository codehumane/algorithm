package quiz

import spock.lang.Specification

class CountFactorsSpec extends Specification {

    def "Solution"() {

        given:
        def countFactors = new CountFactors()

        expect:
        countFactors.solution(N) == count

        where:
        N  || count
        24 || 8
    }
}
