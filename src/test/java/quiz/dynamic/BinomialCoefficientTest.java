package quiz.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Slf4j
public class BinomialCoefficientTest {

    private static Stream<Arguments> binomialCoefficients() {
        return Stream.of(
                Arguments.of(new BinomialCoefficientWithCache()),
                Arguments.of(new BinomialCoefficientWithNoCache())
        );
    }

    @ParameterizedTest
    @MethodSource("binomialCoefficients")
    public void calculate_1개의_정수에서_1개를_뽑는_경우_1을_반환(BinomialCoefficient binomialCoefficient) throws Exception {
        Assertions.assertEquals(1, binomialCoefficient.calculate(1, 1));
    }

    @ParameterizedTest
    @MethodSource("binomialCoefficients")
    public void calculate_2개의_정수에서_1개를_뽑는_경우_2를_반환(BinomialCoefficient binomialCoefficient) throws Exception {
        Assertions.assertEquals(2, binomialCoefficient.calculate(2, 1));
    }

    @ParameterizedTest
    @MethodSource("binomialCoefficients")
    public void calculate_3개의_정수에서_2개를_뽑는_경우_3을_반환(BinomialCoefficient binomialCoefficient) throws Exception {
        Assertions.assertEquals(3, binomialCoefficient.calculate(3, 2));
    }

    @ParameterizedTest
    @MethodSource("binomialCoefficients")
    public void calculate_3개의_정수에서_1개를_뽑는_경우_3를_반환(BinomialCoefficient binomialCoefficient) throws Exception {
        Assertions.assertEquals(3, binomialCoefficient.calculate(3, 1));
    }

    @ParameterizedTest
    @MethodSource("binomialCoefficients")
    public void calculate_3개의_정수에서_3개를_뽑는_경우_1을_반환(BinomialCoefficient binomialCoefficient) throws Exception {
        Assertions.assertEquals(1, binomialCoefficient.calculate(3, 3));
    }

    @ParameterizedTest
    @MethodSource("binomialCoefficients")
    public void calculate_4개의_정수에서_2개를_뽑는_경우_6을_반환(BinomialCoefficient binomialCoefficient) throws Exception {
        Assertions.assertEquals(6, binomialCoefficient.calculate(4, 2));
    }

    @ParameterizedTest
    @MethodSource("binomialCoefficients")
    public void calculate_큰수(BinomialCoefficient binomialCoefficient) throws Exception {
        log.info(binomialCoefficient.getClass().getName());
        // 숫자가 커질 수록 캐시 없는 로직이 압도적으로 오래 걸린다.
        Assertions.assertEquals(125970, binomialCoefficient.calculate(20, 8));
    }
}