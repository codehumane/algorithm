package quiz

import spock.lang.Specification

class MinPerimeterRectangleSpec extends Specification {

    def solution() {

        given:
        def rectangle = new MinPerimeterRectangle()

        expect:
        rectangle.solution(N) == minPerimeter

        where:
        N  || minPerimeter
        30 || 22
        1  || 4
        2  || 6
        3  || 8
        4  || 8
        6  || 10
        9  || 12
    }
}
