package quiz.etc


import spock.lang.Specification

class NestingSpec extends Specification {

    def "Solution"() {

        given:
        def nesting = new Nesting()

        expect:
        nesting.solution(S) == isNesting

        where:
        S            || isNesting
        ""           || 1
        "()"         || 1
        ")"          || 0
        ")("         || 0
        "()()"       || 1
        "()("        || 0
        "())"        || 0
        "(()(())())" || 1
    }
}
