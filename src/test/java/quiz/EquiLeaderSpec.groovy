package quiz

import spock.lang.Specification

class EquiLeaderSpec extends Specification {

    def "Solution"(int[] A, int count) {

        given:
        def leader = new EquiLeader()

        expect:
        leader.solution(A) == count

        where:
        A                  | count
        [1]                | 0
        [1, 1]             | 1
        [1, 1, 1]          | 2
        [1, 1, 2, 1, 1]    | 4
        [4, 3, 4, 4, 4, 2] | 2
    }
}
