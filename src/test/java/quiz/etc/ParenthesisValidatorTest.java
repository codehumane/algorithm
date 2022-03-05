package quiz.etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParenthesisValidatorTest {

    @Test
    public void validate_열고_닫으면_유효함() throws Exception {
        // Given
        ParenthesisValidator validator = new ParenthesisValidator();

        // When
        boolean valid = validator.validate("()");

        // Then
        Assertions.assertTrue(valid);
    }

    @Test
    public void validate_열고_닫은게_연속되어도_유효함() throws Exception {
        // Given
        ParenthesisValidator validator = new ParenthesisValidator();

        // When
        boolean valid = validator.validate("()()");

        // Then
        Assertions.assertTrue(valid);
    }

    @Test
    public void validate_열지_않고_닫으면_유효하지_않음() throws Exception {
        // Given
        ParenthesisValidator validator = new ParenthesisValidator();

        // When
        boolean valid = validator.validate("())");

        // Then
        Assertions.assertFalse(valid);
    }

    @Test
    public void validate_열고_닫음의_갯수가_동일하지_않으면_유효하지_않음() throws Exception {
        // Given
        ParenthesisValidator validator = new ParenthesisValidator();

        // When
        boolean valid = validator.validate("((((()");

        // Then
        Assertions.assertFalse(valid);
    }

    @Test
    public void validate_열고_닫음의_갯수는_짝을_이루지만_순서가_잘못되면_유효하지_않음() throws Exception {
        // Given
        ParenthesisValidator validator = new ParenthesisValidator();

        // When
        boolean valid = validator.validate("()))((()");

        // Then
        Assertions.assertFalse(valid);
    }

    @Test
    public void validate_괄호짝이_내장되어도_유효함() throws Exception {
        // Given
        ParenthesisValidator validator = new ParenthesisValidator();

        // When
        boolean valid = validator.validate("(())");

        // Then
        Assertions.assertTrue(valid);
    }
}
