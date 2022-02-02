package quiz.stackqueue

import quiz.stackqueue.Brackets
import spock.lang.Specification

class BracketsSpec extends Specification {

    def "solution"() {

        given:
        def brackets = new Brackets()

        expect:
        brackets.solution(S) == isNested

        where:
        S          || isNested
        ""         || 1
        "["        || 0
        "[]"       || 1
        "{[()()]}" || 1
        "([)()]"   || 0
        "))"       || 0
        "(("       || 0
    }
}
