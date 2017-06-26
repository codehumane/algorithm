package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModularInverseTest {

    @Test
    public void get() throws Exception {
        assertEquals("..., -2, 5, 12, ...의 정수 집합 중 연산의 특성상 5를 반환", 5, ModularInverse.get(3, 7));
    }

    @Test
    public void get_역수가_존재하지_않으면_음수1을_반환해야_한다() throws Exception {
        assertEquals(-1, ModularInverse.get(2, 6));
    }

    @Test
    public void getByEuclidExtended() throws Exception {
        assertEquals(-2, ModularInverse.getByEuclidExtended(3, 7));
    }

    @Test
    public void getByEuclidExtended_역수가_존재하지_않는_경우() throws Exception {
        assertEquals(-1, ModularInverse.getByEuclidExtended(2, 6));
    }
}