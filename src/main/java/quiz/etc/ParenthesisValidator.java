package quiz.etc;

/**
 * 괄호 "(, )"에 대한 유효성을 체크하는 문제를 풀어보자
 * 제대로된 괄호 사용의 예
 * ()()()()
 * ((()))
 * 잘못된 괄호 사용의 예
 * (((((((((())
 * ))))))))()()
 * )()()(
 */
public class ParenthesisValidator {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public boolean validate(String input) {
        return validateSize(input) && validateStartEnd(input) && validateOpenClosePair(input);
    }

    private boolean validateSize(String input) {
        if (input == null) {
            return false;
        }

        if (input.isEmpty()) {
            return false;
        }

        if (input.length() % 2 != 0) {
            return false;
        }

        return true;
    }

    private boolean validateStartEnd(String input) {
        if (!input.startsWith("(")) {
            return false;
        }

        if (!input.endsWith(")")) {
            return false;
        }

        return true;
    }

    private boolean validateOpenClosePair(String input) {
        int openSize = 0;
        for (int i = 0; i < input.length(); i++) {
            char charAt = input.charAt(i);

            if (isOpen(charAt)) {
                openSize++;

            } else if (isClose(charAt)) {
                openSize--;
                if (openSize < 0) {
                    return false;
                }

            } else {
                return false;
            }
        }

        if (openSize != 0) {
            return false;
        }

        return true;
    }

    private boolean isClose(char charAt) {
        return CLOSE == charAt;
    }

    private boolean isOpen(char charAt) {
        return OPEN == charAt;
    }
}
