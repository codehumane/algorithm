package quiz;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void convert_최소값_1입력시_숫자_그대로_1을_반환한다() throws Exception {
        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();

        // When
        String result = fizzBuzz.convert(1);

        // Then
        Assert.assertEquals("1", result);
    }

    @Test
    public void convert_2가_입력된_경우_1부터_2까지_숫자_그대로를_붙여_반환한다() throws Exception {
        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();

        // When
        String result = fizzBuzz.convert(2);

        // Then
        Assert.assertEquals("12", result);
    }

    @Test
    public void convert_3이_입력된_경우_1과_2는_그대로_그리고_3의_배수인_3은_fizz로_변환하여_반환한다() throws Exception {
        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();

        // When
        String result = fizzBuzz.convert(3);

        // Then
        Assert.assertEquals("12fizz", result);
    }

    @Test
    public void convert_5의_배수_자리에는_buzz로_변환하여_반환한다() throws Exception {
        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();

        // When
        String result = fizzBuzz.convert(5);

        // Then
        Assert.assertEquals("12fizz4buzz", result);
    }

    @Test
    public void convert_3과_5의_공통_배수_자리에는_fizzbuzz로_변환하여_반환한다() throws Exception {
        // Given
        FizzBuzz fizzBuzz = new FizzBuzz();

        // When
        String result = fizzBuzz.convert(15);

        // Then
        Assert.assertEquals("12fizz4buzzfizz78fizzbuzz11fizz1314fizzbuzz", result);
    }
}
