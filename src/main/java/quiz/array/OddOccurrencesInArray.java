package quiz.array;

/**
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 */
class OddOccurrencesInArray {

    int solution(int[] A) {

        int el = 0;
        for (int a : A) {
            // `같지 않음`이 키워드
            el ^= a;
        }

        //  1:    1
        //  2:   10
        //  3:   11
        //  4:  100
        //  5:  101
        //  6:  110
        //  7:  111
        //  8: 1000
        //  9: 1001
        // 10: 1010
        // 11: 1011
        // 12: 1100
        // 13: 1101
        // 14: 1110
        // 15: 1111

        return el;
    }
}
