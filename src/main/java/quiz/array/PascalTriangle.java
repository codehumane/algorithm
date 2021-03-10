package quiz.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.<br/>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            triangle.add(generateNextRow(triangle, i));
        }

        return triangle;
    }

    private List<Integer> generateNextRow(List<List<Integer>> triangle, int row) {
        if (row == 0) return Collections.singletonList(1);

        final List<Integer> next = new ArrayList<>(row + 1);
        final List<Integer> last = triangle.get(row - 1);

        // 첫 번째 값은 무조건 1
        next.add(1);

        for (int i = 1; i < row; i++) {
            next.add(last.get(i - 1) + last.get(i));
        }

        // 마지막 값도 무조건 1
        next.add(1);

        return next;
    }

}
