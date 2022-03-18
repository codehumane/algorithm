package quiz.graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/employee-importance/
 */
public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {

        var idToEmployee = employees
                .stream()
                .collect(Collectors.toMap(e -> e.id, e -> e));

        var sum = 0;
        var deque = new ArrayDeque<Employee>();
        var start = idToEmployee.get(id);

        if (start == null) return sum;

        deque.offer(start);

        while (!deque.isEmpty()) {
            var e = deque.poll();

            if (e.subordinates != null) {
                for (Integer subId : e.subordinates) {
                    deque.offer(idToEmployee.get(subId));
                }
            }

            sum += e.importance;
        }

        return sum;
    }

    static class Employee {
        int id;
        int importance;
        List<Integer> subordinates;
    }

}
