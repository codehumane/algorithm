package quiz

import spock.lang.Specification

class StoneWallSpec extends Specification {

    def "Solution"(int[] H, int count) {

        given:
        def wall = new StoneWall()

        expect:
        wall.solution(H) == count

        where:
        H                           | count
        [1]                         | 1
        [2, 2]                      | 1
        [2, 1]                      | 2
        [2, 3]                      | 2
        [2, 3, 4]                   | 3
        [2, 3, 2]                   | 2
        [2, 3, 1]                   | 3
        [8, 8, 5, 7, 9, 8, 7, 4, 8] | 7
    }
}
