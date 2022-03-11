package quiz.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class RandomPickWithWeightTest {

    @Test
    void example1() {
        var w = new int[]{1};
        var solution = new RandomPickWithWeight(w);
        assertEquals(0, solution.pickIndex());
        assertEquals(0, solution.pickIndex());
        assertEquals(0, solution.pickIndex());
    }

    @Test
    void example2() {
        var w = new int[]{1, 3};
        var solution = new RandomPickWithWeight(w);
        var indexToCount = IntStream
                .range(0, 40000)
                .mapToObj(i -> solution.pickIndex())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        HashMap::new,
                        Collectors.counting()
                ));

//        assertEquals(2, indexToCount.get(0));
//        assertEquals(6, indexToCount.get(1));
        log.info("example2: {}", indexToCount);
    }

    @Test
    void custom() {
        var w = new int[]{1, 1, 1};
        var solution = new RandomPickWithWeight(w);
        var indexToCount = IntStream
                .range(0, 300000)
                .mapToObj(i -> solution.pickIndex())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        HashMap::new,
                        Collectors.counting()
                ));

//        assertEquals(100, indexToCount.get(0));
//        assertEquals(100, indexToCount.get(1));
//        assertEquals(100, indexToCount.get(2));
        log.info("custom: {}", indexToCount);
    }

}