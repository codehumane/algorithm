package quiz.etc;

class Fish {

    int solution(int[] A, int[] B) {

        int N = A.length;
        Stack upstream = new Stack(N);
        Stack downstream = new Stack(N);

        for (int i = 0; i < N; i++) {

            if (B[i] == 1) {
                downstream.push(A[i]);
                continue;
            }

            while (true) {
                if (downstream.size() == 0) {
                    upstream.push(A[i]);
                    break;
                }
                if (downstream.peek() > A[i]) {
                    break;
                }

                downstream.pop();
            }
        }

        return upstream.size() + downstream.size();
    }

    private class Stack {

        private final int[] elements;
        private int lastIndex = -1;

        Stack(int capacity) {
            this.elements = new int[capacity];
        }

        void push(int element) {
            elements[++lastIndex] = element;
        }

        int peek() {
            return elements[lastIndex];
        }

        int pop() {
            return elements[lastIndex--];
        }

        int size() {
            return lastIndex + 1;
        }
    }
}
