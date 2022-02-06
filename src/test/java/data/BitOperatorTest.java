package data;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class BitOperatorTest {

    @Test
    public void numberToBinaryString() {
        log.info("integer to binary conversion.");
        printBinary(1);
        printBinary(-1);
        printBinary(0);
        printBinary(15);
        printBinary(-15);
        printBinary(3);
        printBinary(-3);
    }

    @Test
    public void bitAnd() {
        int target = 13;
        int operand = 5;
        int operated = target & operand;

        log.info("[{} & {}]", target, operand);
        printBinary(target);
        printBinary(operand);
        printBinary(operated);
    }

    @Test
    public void bitInclusiveOr() {
        int target = 13;
        int operand = 5;
        int operated = target | operand;

        log.info("[{} | {}]", target, operand);
        printBinary(target);
        printBinary(operand);
        printBinary(operated);
    }

    @Test
    public void bitExclusiveOr() {
        int target = 10;
        int operand = 12;
        int operated = target ^ operand;

        log.info("[{} ^ {}]", target, operand);
        printBinary(target);
        printBinary(operand);
        printBinary(operated);
    }

    @Test
    public void bitComplement() {
        int target = 13;
        int operated = ~target;

        log.info("[~{}]", target);
        printBinary(target);
        printBinary(operated);
    }

    @Test
    public void bitLeftShiftToPositiveNumber() {
        int target = 13;
        int shiftNumber = 6;
        int operated = target << shiftNumber;

        log.info("[{} << {}]", target, shiftNumber);
        printBinary(target);
        printBinary(operated);
    }

    @Test
    public void bitLeftShiftToNegativeNumber() {
        int target = -13;
        int shiftNumber = 6;
        int operated = target << shiftNumber;

        log.info("[{} << {}]", target, shiftNumber);
        printBinary(target);
        printBinary(operated);
    }

    @Test
    public void bitRightShiftToPositiveNumber() {
        int target = 121;
        int shiftNumber = 6;
        int operated = target >> shiftNumber;

        log.info("[{} >> {}]", target, shiftNumber);
        printBinary(target);
        printBinary(operated);
    }

    @Test
    public void bitRightShiftToNegativeNumber() {
        int target = -121;
        int shiftNumber = 6;
        int operated = target >> shiftNumber;

        log.info("[{} >> {}]", target, shiftNumber);
        printBinary(target);
        printBinary(operated);
    }

    @Test
    public void bitUnsignedRightShiftToPositiveNumber() {
        int target = 121;
        int shiftNumber = 6;
        int operated = target >>> shiftNumber;

        log.info("[{} >>> {}]", target, shiftNumber);
        printBinary(target);
        printBinary(operated);
    }

    @Test
    public void bitUnsignedRightShiftToNegativeNumber() {
        int target = -121;
        int shiftNumber = 6;
        int operated = target >>> shiftNumber;

        log.info("[{} >>> {}]", target, shiftNumber);
        printBinary(target);
        printBinary(operated);
    }

    private static void printBinary(int input) {
        String binary = Integer.toBinaryString(input);
        String binaryFormatted = String.format("%32s", binary).replace(' ', '0');
        log.info("{} : {}", binaryFormatted, input);
    }
}
