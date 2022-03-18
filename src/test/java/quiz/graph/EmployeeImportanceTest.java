package quiz.graph;

import org.junit.jupiter.api.Test;
import quiz.graph.EmployeeImportance.Employee;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeImportanceTest {

    private final EmployeeImportance solution = new EmployeeImportance();

    @Test
    void example1() {

        // given
        var e1 = new Employee();
        var e2 = new Employee();
        var e3 = new Employee();
        e1.id = 1;
        e2.id = 2;
        e3.id = 3;
        e1.importance = 5;
        e2.importance = 3;
        e3.importance = 3;
        e1.subordinates = List.of(2, 3);

        // when
        var result = solution.getImportance(List.of(e1, e2, e3), 1);

        // then
        assertEquals(11, result);
    }

    @Test
    void example2() {

        // given
        var e1 = new Employee();
        var e2 = new Employee();
        e1.id = 1;
        e2.id = 5;
        e1.importance = 2;
        e2.importance = -3;
        e1.subordinates = List.of(5);

        // when
        var result = solution.getImportance(List.of(e1, e2), 5);

        // then
        assertEquals(-3, result);
    }
    
}