package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModularExponentiationTest {

    @Test
    public void calc_밑이_5이고_모듈러_N이_3인_모듈러_지수_연산() throws Exception {
        assertEquals(2, ModularExponentiation.calc(5, 1, 3));
        assertEquals(1, ModularExponentiation.calc(5, 2, 3));
        assertEquals(2, ModularExponentiation.calc(5, 3, 3));
        assertEquals(1, ModularExponentiation.calc(5, 4, 3));
        assertEquals(2, ModularExponentiation.calc(5, 5, 3));
    }

    @Test
    public void calc_밑이_3이고_모듈러_N이_7인_모듈러_지수_연산() throws Exception {
        assertEquals(3, ModularExponentiation.calc(3, 1, 7));
        assertEquals(2, ModularExponentiation.calc(3, 2, 7));
        assertEquals(6, ModularExponentiation.calc(3, 3, 7));
        assertEquals(4, ModularExponentiation.calc(3, 4, 7));
        assertEquals(5, ModularExponentiation.calc(3, 5, 7));
    }

    @Test
    public void calcBySquare_밑이_5이고_모듈러_N이_3인_모듈러_지수_연산() throws Exception {
        assertEquals(2, ModularExponentiation.calcBySquare(5, 1, 3));
        assertEquals(1, ModularExponentiation.calcBySquare(5, 2, 3));
        assertEquals(2, ModularExponentiation.calcBySquare(5, 3, 3));
        assertEquals(1, ModularExponentiation.calcBySquare(5, 4, 3));
        assertEquals(2, ModularExponentiation.calcBySquare(5, 5, 3));
    }

    @Test
    public void calcBySquare_밑이_3이고_모듈러_N이_7인_모듈러_지수_연산() throws Exception {
        assertEquals(3, ModularExponentiation.calcBySquare(3, 1, 7));
        assertEquals(2, ModularExponentiation.calcBySquare(3, 2, 7));
        assertEquals(6, ModularExponentiation.calcBySquare(3, 3, 7));
        assertEquals(4, ModularExponentiation.calcBySquare(3, 4, 7));
        assertEquals(5, ModularExponentiation.calcBySquare(3, 5, 7));
    }

    @Test
    public void calcByPowerOf2_밑이_5이고_모듈러_N이_3인_모듈러_지수_연산() throws Exception {
        assertEquals(2, ModularExponentiation.calcByPowerOf2(5, 1, 3));
        assertEquals(1, ModularExponentiation.calcByPowerOf2(5, 2, 3));
        assertEquals(2, ModularExponentiation.calcByPowerOf2(5, 3, 3));
        assertEquals(1, ModularExponentiation.calcByPowerOf2(5, 4, 3));
        assertEquals(2, ModularExponentiation.calcByPowerOf2(5, 5, 3));
    }

    @Test
    public void calcByPowerOf2_밑이_3이고_모듈러_N이_7인_모듈러_지수_연산() throws Exception {
        assertEquals(3, ModularExponentiation.calcByPowerOf2(3, 1, 7));
        assertEquals(2, ModularExponentiation.calcByPowerOf2(3, 2, 7));
        assertEquals(6, ModularExponentiation.calcByPowerOf2(3, 3, 7));
        assertEquals(4, ModularExponentiation.calcByPowerOf2(3, 4, 7));
        assertEquals(5, ModularExponentiation.calcByPowerOf2(3, 5, 7));
    }

    public void calc_밑이_5이고_지수가_117이면서_모듈러_N이_19인_경우() throws Exception {
        assertEquals(1, ModularExponentiation.calc(5, 117, 19));
        assertEquals(1, ModularExponentiation.calcBySquare(5, 117, 19));
        assertEquals(1, ModularExponentiation.calcByPowerOf2(5, 117, 19));
    }
}