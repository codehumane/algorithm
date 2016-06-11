package quiz;

/**
 * [Task Description]
 * <p>
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 * <p>
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
 * <p>
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(log(N));
 * expected worst-case space complexity is O(1).
 * <p>
 * <p>
 * [What I've learned]
 * <p>
 * 1. Extreme (boundary value) test required.
 * 2. More basic library usage knowledge needed.
 */
class BinaryGap {

    public int computeByMySolution(int N) {
        int index = 0;
        int length = -1;
        int maxLength = 0;

        while (true) {
            // 맨 뒷자리부터 확인한다.
            int operand = 1 << index++;
            if (operand > N || operand < 0) {
                break;
            }

            if ((operand & N) == operand) { // 해당 자리수는 1
                if (length > maxLength) {
                    maxLength = length;
                }
                length = 0;
            } else {
                if (length >= 0) {
                    length++;
                }
            }
        }

        return maxLength;
    }

    /**
     * http://www.programcreek.com/2013/02/twitter-codility-problem-max-binary-gap/
     * says "The key to solve this problem is the fact that an integer x & 1 will get the last digit of the integer."
     * and the code is as belows.
     *
     * @param N 입력값
     * @return 결과값
     */
    public int computeByOthersSolution(int N) {
        int max = 0;
        int count = -1;
        int r;

        while (N > 0) {
            // get right most bit & shift right
            r = N & 1;
            N = N >> 1;

            if (0 == r && count >= 0) {
                count++;
            }

            if (1 == r) {
                max = count > max ? count : max;
                count = 0;
            }
        }

        return max;
    }
}


