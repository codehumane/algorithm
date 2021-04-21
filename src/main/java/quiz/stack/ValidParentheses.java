package quiz.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.<br/>
 * <br/>
 * An input string is valid if:<br/>
 * <br/>
 * 1. Open brackets must be closed by the same type of brackets.<br/>
 * 2. Open brackets must be closed in the correct order.<br/>
 * <br/>
 * Constraints:<br/>
 * <br/>
 * 1. 1 <= s.length <= 104<br/>
 * 2. s consists of parentheses only '()[]{}'.<br/>
 */
public class ValidParentheses {

    private static final Map<Character, Character> PAIRS;

    static {
        PAIRS = new HashMap<>();
        PAIRS.put(')', '(');
        PAIRS.put('}', '{');
        PAIRS.put(']', '[');
    }

    public boolean isValid(String s) {
        final Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {

            // (, {, [
            if (PAIRS.containsValue(c)) {
                stack.push(c);
                continue;
            }

            // ), }, ]
            if (stack.isEmpty()) return false;
            if (PAIRS.get(c) != stack.pop()) return false;
        }

        return stack.isEmpty();
    }

}
