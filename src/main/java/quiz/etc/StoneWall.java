package quiz.etc;

class StoneWall {

    int solution(int[] H) {

        int count = 0;
        final Stack stack = new Stack(H.length);

        for (int h : H) {
            while (!stack.isEmpty() && h < stack.seek()) {
                stack.pop();
            }

            if (stack.isEmpty() || h > stack.seek()) {
                stack.push(h);
                count++;
            }
        }

        return count;
    }


    private class Stack {

        private int lastIdx = -1;
        private final int[] elements;

        Stack(int capacity) {
            elements = new int[capacity];
        }

        void push(int el) {
            elements[++lastIdx] = el;
        }

        void pop() {
            lastIdx--;
        }

        int seek() {
            return elements[lastIdx];
        }

        boolean isEmpty() {
            return lastIdx == -1;
        }
    }
}
