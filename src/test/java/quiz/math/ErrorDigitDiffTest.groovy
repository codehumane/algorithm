package quiz.math

import quiz.math.ErrorDigitDiff
import spock.lang.Specification

class ErrorDigitDiffTest extends Specification {

    def "solution"(int N, long result) {

        given:
        def diff = new ErrorDigitDiff()

        expect:
        diff.solution(N) == result

        where:
        N      | result
        132635 | 932635 - 102605
    }

    def "max"(int N, long result) {

        given:
        def diff = new ErrorDigitDiff()

        expect:
        diff.max(N) == result

        where:
        N      | result
        132635 | 932635
        132131 | 932939
        1      | 9
        2      | 9
        3      | 9
        10     | 90
        11     | 99
        12     | 92
        13     | 93
        20     | 90
        21     | 91
        122    | 922
        121    | 929
        112    | 992
    }

    def "min"(int N, long result) {

        given:
        def diff = new ErrorDigitDiff()

        expect:
        diff.min(N) == result

        where:
        N      | result
        132635 | 102605
        1      | 1
        2      | 1
        3      | 1
        10     | 10
        11     | 11
        12     | 10
        13     | 10
        20     | 10
        21     | 11
        122    | 100
        121    | 101
        112    | 110
    }

}
