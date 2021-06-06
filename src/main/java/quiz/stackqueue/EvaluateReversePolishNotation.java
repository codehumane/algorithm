package quiz.stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * Evaluate the value of an arithmetic expression in <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">Reverse Polish Notation.</a><br/>
 * <br/>
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.<br/>
 * <br/>
 * Note that division between two integers should truncate toward zero.<br/>
 * <br/>
 * It is guaranteed that the given RPN expression is always valid. <br/>
 * That means the expression would always evaluate to a result, <br/>
 * and there will not be any division by zero operation.<br/>
 * <br/>
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        final Deque<String> stack = new ArrayDeque<>();

        for (String token : tokens) {
            final Optional<Operations> operation = Operations.parse(token);

            if (operation.isPresent()) {
                stack.push(apply(operation.get(), stack.pop(), stack.pop()));
            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private String apply(Operations operation, String operand2, String operand1) {
        final int o1 = Integer.parseInt(operand1);
        final int o2 = Integer.parseInt(operand2);
        final int result = operation.apply(o1, o2);
        return String.valueOf(result);
    }

    enum Operations {

        PLUS("+", (o1, o2) -> o1 + o2),
        MINUS("-", (o1, o2) -> o1 - o2),
        MULTIPLY("*", (o1, o2) -> o1 * o2),
        DIVIDE("/", (o1, o2) -> o1 / o2);

        private final String operator;
        private final BiFunction<Integer, Integer, Integer> operation;

        public static Optional<Operations> parse(String operator) {

            return Arrays
                    .stream(Operations.values())
                    .filter(o -> o.operator.equals(operator))
                    .findAny();
        }

        Operations(String operator, BiFunction<Integer, Integer, Integer> operation) {
            this.operator = operator;
            this.operation = operation;
        }

        public int apply(int operand1, int operand2) {
            return operation.apply(operand1, operand2);
        }

    }

}
