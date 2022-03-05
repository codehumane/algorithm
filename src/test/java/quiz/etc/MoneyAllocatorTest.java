package quiz.etc;

import lombok.val;
import org.junit.jupiter.api.Test;
import quiz.etc.MoneyAllocator.Target;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyAllocatorTest {

    @Test
    public void allocate_마지막_대상에게_나눠줄_금액이_부족한_경우() throws Exception {

        // given
        val a = new Target("A", 100);
        val b = new Target("B", 50);
        val c = new Target("C", 30);

        // when
        val allocated = MoneyAllocator.allocate(asList(a, b, c), 170);

        // then
        assertEquals(170, allocated);
        assertEquals(100, a.getAllocatedAmount());
        assertEquals(50, b.getAllocatedAmount());
        assertEquals(20, c.getAllocatedAmount());
    }

    @Test
    public void allocate_나눠줄_금액이_부족한_대상이_다수인_경우() throws Exception {

        // given
        val a = new Target("A", 100);
        val b = new Target("B", 50);
        val c = new Target("C", 30);

        // when
        val allocated = MoneyAllocator.allocate(asList(a, b, c), 90);

        // then
        assertEquals(90, allocated);
        assertEquals(90, a.getAllocatedAmount());
        assertEquals(0, b.getAllocatedAmount());
        assertEquals(0, c.getAllocatedAmount());
    }

    @Test
    public void allocate_모두에게_나눠주고도_금액이_남는_경우() throws Exception {

        // given
        val a = new Target("A", 100);
        val b = new Target("B", 50);
        val c = new Target("C", 30);

        // when
        val allocated = MoneyAllocator.allocate(asList(a, b, c), 200);

        // then
        assertEquals(180, allocated);
        assertEquals(a.getMaxAmount(), a.getAllocatedAmount());
        assertEquals(b.getMaxAmount(), b.getAllocatedAmount());
        assertEquals(c.getMaxAmount(), c.getAllocatedAmount());
    }
}