package quiz

import spock.lang.Specification

class MaxProfitSpec extends Specification {

    def "Solution"(int[] A, int result) {

        given:
        def maxProfit = new MaxProfit()

        expect:
        maxProfit.solution(A) == result

        where:
        A                                          | result
        []                                         | 0
        [1]                                        | 0
        [1, 2]                                     | 1
        [2, 2]                                     | 0
        [2, 1]                                     | 0
        [1, 2, 3]                                  | 2

        [6, 1, 3, 4, 2, 5]                         | 4
        [2, 5, 1]                                  | 3
        [2, 5, 1, 3]                               | 3
        [2, 5, 1, 5]                               | 4
        
        [23171, 21011, 21123, 21366, 21013, 21367] | 356
    }
}
