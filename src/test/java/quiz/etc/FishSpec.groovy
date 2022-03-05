package quiz.etc

import spock.lang.Specification

class FishSpec extends Specification {

    void solution(int[] A, int[] B, int aliveCount) {

        given:
        def fish = new Fish()

        expect:
        fish.solution(A, B) == aliveCount

        where:
        A               | B               | aliveCount
        [1]             | [0]             | 1
        [1, 2]          | [1, 0]          | 1
        [1, 2]          | [0, 1]          | 2
        [1, 2]          | [0, 0]          | 2
        [1, 2]          | [1, 1]          | 2
        [4, 3, 2, 1, 5] | [0, 1, 0, 0, 0] | 2
        [4, 3, 2, 1, 5] | [0, 1, 0, 1, 0] | 2
        [4, 3, 2, 1, 5] | [0, 0, 0, 1, 0] | 4
    }
}
