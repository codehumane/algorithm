package quiz;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
class FrogJump {

    int solution(int X, int Y, int D) {
        int counts = (Y - X) / D;
        if ((Y - X) % D != 0) {
            counts += 1;
        }

        return counts;
    }
}
