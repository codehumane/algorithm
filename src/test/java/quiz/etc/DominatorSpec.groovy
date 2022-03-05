package quiz.etc

import spock.lang.Specification

class DominatorSpec extends Specification {

    def "Solution"(int[] A, int[] indices) {

        given:
        def dominator = new Dominator()

        expect:
        indices.contains(dominator.solution(A))

        where:
        A                                      | indices
        []                                     | [-1]
        [1]                                    | [0]
        [1, 2]                                 | [-1]
        [1, 1]                                 | [0, 1]
        [1, 2, 3]                              | [-1]
        [1, 2, 2]                              | [1, 2]
        [2, 1, 2]                              | [0, 2]
        [2, 2, 2]                              | [0, 1, 2]
        [3, 4, 3, 2, 3, -1, 3, 3]              | [0, 2, 4, 6, 7]
        [2, 4, -1, 3, 3, 3, 3, 3]              | [3, 4, 5, 6, 7]
        [2, 4, 4, 3, 3, 3, 3, 3]               | [3, 4, 5, 6, 7]
        [-2147483648, -2147483648, 2147483647] | [0, 1]
    }
}
