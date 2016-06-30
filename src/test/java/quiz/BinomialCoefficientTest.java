package quiz;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(value = Parameterized.class)
public class BinomialCoefficientTest<T extends BinomialCoefficient> {

    private T binomialCoefficient;
    private Class<T> clazz;

    public BinomialCoefficientTest(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Parameterized.Parameters
    public static List<Class> fanMeetingClasses() {
        List<Class> classes = new ArrayList<>();
        classes.add(BinomialCoefficientWithCache.class);
        classes.add(BinomialCoefficientWithNoCache.class);
        return classes;
    }

    @Before
    public void setup() throws IllegalAccessException, InstantiationException {
        this.binomialCoefficient = clazz.newInstance();
    }

    @Test
    public void calculate_1개의_정수에서_1개를_뽑는_경우_1을_반환() throws Exception {
        Assert.assertEquals(1, binomialCoefficient.calculate(1, 1));
    }

    @Test
    public void calculate_2개의_정수에서_1개를_뽑는_경우_2를_반환() throws Exception {
        Assert.assertEquals(2, binomialCoefficient.calculate(2, 1));
    }

    @Test
    public void calculate_3개의_정수에서_2개를_뽑는_경우_3을_반환() throws Exception {
        Assert.assertEquals(3, binomialCoefficient.calculate(3, 2));
    }

    @Test
    public void calculate_3개의_정수에서_1개를_뽑는_경우_3를_반환() throws Exception {
        Assert.assertEquals(3, binomialCoefficient.calculate(3, 1));
    }

    @Test
    public void calculate_3개의_정수에서_3개를_뽑는_경우_1을_반환() throws Exception {
        Assert.assertEquals(1, binomialCoefficient.calculate(3, 3));
    }

    @Test
    public void calculate_4개의_정수에서_2개를_뽑는_경우_6을_반환() throws Exception {
        Assert.assertEquals(6, binomialCoefficient.calculate(4, 2));
    }

    @Test
    public void calculate_큰수() throws Exception {
        log.info(binomialCoefficient.getClass().getName());
        // 숫자가 커질 수록 캐시 없는 로직이 압도적으로 오래 걸린다.
        Assert.assertEquals(125970, binomialCoefficient.calculate(20, 8));
    }
}