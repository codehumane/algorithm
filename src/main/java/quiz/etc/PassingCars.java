package quiz.etc;

class PassingCars {

    private static final int TO_EAST = 0;
    private static final int MAX_PASSING = 1000000000;

    int solution(int[] A) {

        int toEast = 0;
        int passing = 0;

        for (int direction : A) {
            if (direction == TO_EAST) toEast++;
            else if (toEast > 0) passing += toEast;
            if (passing > MAX_PASSING) return -1;
        }

        return passing;
    }
}
