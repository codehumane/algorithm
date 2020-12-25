package data.tree;

/**
 * Given a positive integer num,
 * write a function which returns True
 * if num is a perfect square else False.
 * <p>
 * Follow up: Do not use any built-in library function such as sqrt.
 * <p>
 * 1 <= num <= 2^31 - 1
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;

        while (left <= right) {
            final int mid = left + (right - left) / 2;
            final long squared = (long) mid * mid;

            if (squared > num) right = mid - 1;
            else if (squared < num) left = mid + 1;
            else return true;
        }

        return false;
    }

}
