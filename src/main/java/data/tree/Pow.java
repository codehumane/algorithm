package data.tree;

/**
 * Implement pow(x, n),
 * which calculates x raised to the power n (i.e. xn).
 */
public class Pow {
    public double myPow(double x, int n) {

        double result = 1;
        double power = (n >= 0) ? x : (1d / x);
        long exp = Math.abs((long) n);

        while (exp != 0) {
            if ((exp & 1) == 1) result *= power;
            power *= power;
            exp = exp >> 1;
        }

        return result;
    }
}
