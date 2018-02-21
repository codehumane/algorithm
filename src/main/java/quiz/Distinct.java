package quiz;

class Distinct {

    int solution(int[] A) {

        int count = 0;
        int[] distinct = new int[A.length];

        for (int a : A) {
            if (!contains(distinct, count, a))
                distinct[count++] = a;
        }

        return count;
    }

    private boolean contains(int[] ints, int size, int target) {
        for (int i = 0; i < size; i++) {
            if (ints[i] == target) {
                return true;
            }
        }

        return false;
    }
}
