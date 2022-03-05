package quiz.etc


import spock.lang.Specification

class PassingCarsSpec extends Specification {

    def "Solution"(int[] A, int count) {

        given:
        def cars = new PassingCars()

        expect:
        cars.solution(A) == count

        where:
        A               | count
        [0, 1, 0, 1, 1] | 5
        [0]             | 0
        [1]             | 0
        [0, 1]          | 1
        [1, 0]          | 0
        [0, 0]          | 0
        [1, 1]          | 0
    }
}
