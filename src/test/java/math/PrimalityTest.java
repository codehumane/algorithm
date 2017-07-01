package math;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimalityTest {

    @Test
    public void isPrimary_기본적인_경우() throws Exception {
        assertTrue(Primality.isPrimary(2));
        assertTrue(Primality.isPrimary(3));
        assertFalse(Primality.isPrimary(4));
        assertTrue(Primality.isPrimary(5));
        assertTrue(Primality.isPrimary(13));
        assertFalse(Primality.isPrimary(16));
    }

    @Test
    public void isPrimary_페르마의_소정리에_적용되지_않는_경우() throws Exception {
        // 341 = 11 * 31인데, 2 ^ 340 ≡ 1 mod 341이 성립한다.
        // 가능한 여러 번 실행시켜, 내부적으로 만드는 임의의 정수값이 2인 경우가 1번 이상 되도록 만든다.
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
        assertFalse(Primality.isPrimary(341));
    }
}