package quiz

import spock.lang.Specification

class FlagsTest extends Specification {

    def "배열 크기가 2 이하일 때는, 비교할 대상이 없으므로, 플래그는 최대 0개"(int[] A, int result) {

        given:
        def flags = new Flags()

        expect:
        flags.solution(A) == result

        where:
        A      | result
        [1]    | 0
        [1, 3] | 0
    }

    def "배열 크기가 3일 때, 플래그는 최대 1개"(int[] A, int result) {

        given:
        def flags = new Flags()

        expect:
        flags.solution(A) == result

        where:
        A         | result
        [1, 2, 1] | 1 // 가운데 수가 앞자리와 뒷자리 보다 큰 경우
        [2, 3, 1] | 1 // 가운데 수가 앞자리와 뒷자리 보다 큰 경우
        [3, 4, 5] | 0 // 가운데 수가 앞자리 보다 크지만, 뒷자리 보다는 작은 경우
        [6, 5, 3] | 0 // 가운데 수가 뒷자리 보다 크지만, 앞자리 보다는 작은 경우
        [3, 2, 3] | 0 // 가운데 수가 앞자리와 뒷자리 보다 모두 작은 경우
    }

    def "배열 크기가 4일 때도, 3과 같이 플래그는 최대 1개"(int[] A, int result) {

        given:
        def flags = new Flags()

        expect:
        flags.solution(A) == result

        where:
        A            | result
        [1, 2, 1, 2] | 1
        [2, 3, 2, 1] | 1
        [3, 4, 5, 3] | 1
        [6, 5, 3, 2] | 0
        [3, 2, 3, 3] | 0
    }

    def "배열 크기가 7 이상일 때는 거리도 함께 고려해야 한다"(int[] A, int result) {

        given:
        def flags = new Flags()

        expect:
        flags.solution(A) == result

        where:
        A                           | result
        [0, 1, 0, 1, 0, 1, 0]       | 2 // peak는 3개지만, peak들 간의 거리가 모두 2이므로, 최대 플래그는 2가 된다.
        [0, 1, 0, 0, 1, 0, 1, 0]    | 2 // peak는 3개지만, peak들 간의 거리가 3인 것이 1개이므로, 최대 플래그는 2가 된다.
        [0, 1, 0, 1, 0, 0, 1, 0]    | 2 // peak는 3개지만, peak들 간의 거리가 3인 것이 1개이므로, 최대 플래그는 2가 된다.
        [0, 1, 0, 0, 1, 0, 0, 1, 0] | 3 // peak가 3개이고, peak들 간의 거리도 모두 3이므로, 최대 플래그는 3이 된다.
    }

    def "코딜리티 제공 예시"() {

        given:
        def flags = new Flags()
        final int[] A = [1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2]

        when:
        def result = flags.solution(A)

        then:
        3 == result
    }

    def "코드 최적화를 위한 일반해 찾기"(int[] A, int result) {

        given:
        def flags = new Flags()

        expect:
        flags.solution(A) == result

        where:
        A                                                                     | result
        [0, 1, 0]                                                             | 1 // 예외
        [0, 1, 0, 1, 0]                                                       | 2 // 2 * 1 + 3 = 5
        [0, 1, 0, 0, 1, 0, 0, 1, 0]                                           | 3 // 3 * 2 + 3 = 9
        [0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0]                         | 4 // 4 * 3 + 3 = 15
        [0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0] | 5 // 5 * 4 + 3 = 23

        // 따라서, distance를 d라고 할 때(2부터 시작함),
        // d * (d - 1) + 3이 N(A의 길이)보다 작거나 같은 경우만 조사하면 된다.
        // 시간 복잡도는 대략 O(N * log N)이 되는 것.
    }
}
