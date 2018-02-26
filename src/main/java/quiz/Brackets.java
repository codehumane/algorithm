package quiz;

class Brackets {

    private static final int SUCCESS = 1;
    private static final int FAIL = 0;

    int solution(String S) {

        final Stack stack = new Stack(S);
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            switch (c) {
                case '{':
                case '(':
                case '[':
                    stack.push(c);
                    break;
                default:
                    if (stack.count() == 0)
                        return FAIL;

                    char pop = stack.pop();
                    if (pop == '{' && c == '}') break;
                    if (pop == '[' && c == ']') break;
                    if (pop == '(' && c == ')') break;

                    return FAIL;
            }
        }

        return stack.count() == FAIL ? SUCCESS : FAIL;
    }

    private class Stack {

        private int idx = -1;
        private final char[] chars;

        Stack(String S) {
            chars = new char[S.length()];
        }

        void push(char c) {
            chars[++idx] = c;
        }

        char pop() {
            return chars[idx--];
        }

        int count() {
            return idx + 1;
        }
    }

}
