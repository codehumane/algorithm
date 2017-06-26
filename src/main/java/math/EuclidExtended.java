package math;

import lombok.Value;

/**
 * 두 개의 양의 정수 a, b(a ≥ b ≥ 0)가 주어졌을 때, <br/>
 * d = gcd(a, b) 이면서 ax + by = d를 만족하는 정수 x, y, d를 구하라.
 */
class EuclidExtended {

    static Result get(int a, int b) {
        if (b == 0) return Result.of(1, 0, a);
        final Result r = get(b, a % b);
        return Result.of(r.y, r.x - a / b * r.y, r.d);
    }

    @Value
    static class Result {

        private final int x;
        private final int y;
        private final int d;

        static Result of(int x, int y, int d) {
            return new Result(x, y, d);
        }
    }
}
