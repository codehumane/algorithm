package quiz.etc;

/**
 * Moving Average Definition by wikipedia(https://en.wikipedia.org/wiki/Moving_average) : <br/>
 * Given a series of numbers and a fixed subset size, the first element of the moving average is <br/>
 * obtained by taking the average of the initial fixed subset of the number series. <br/>
 * Then the subset is modified by "shifting forward"; that is, <br/>
 * excluding the first number of the series and including the next number following the original subset in the series. <br/>
 * This creates a new subset of numbers, which is averaged. <br/>
 * This process is repeated over the entire data series. <br/>
 * The plot line connecting all the (fixed) averages is the moving average. <br/>
 * A moving average is a set of numbers, each of which is the average of the corresponding subset of a larger set of datum points. <br/>
 * A moving average may also use unequal weights for each datum value in the subset to emphasize particular values in the subset. <br/>
 */
public class MovingAverage {

    /**
     * 아래 메서드의 수행 횟수는 (count - 1)+ (input.length - count + 1)이 된다.
     */
    double[] computeByLinearTime(double[] input, Integer count) {
        double[] result = new double[input.length - 1];
        int inputLength = input.length;
        int resultIdx = 0;

        double partialSum = 0;
        for (int i = 0; i < count - 1; ++i) {
            partialSum += input[i];
        }

        for (int i = count - 1; i < inputLength; ++i) {
            partialSum += input[i];
            result[resultIdx++] = partialSum / count;
            partialSum -= input[i - count + 1];
        }

        return result;
    }

    /**
     * 아래 메서드의 수행 횟수는 (input.length - count + 1) * count 이다.
     */
    //    double[] compute(double[] input, Integer count) {
//        double[] result = new double[input.length - 1];
//        int inputLength = input.length;
//        int resultIdx = 0;
//
//        for (int i = count - 1; i < inputLength; ++i) {
//            double partialSum = 0;
//            for (int j = 0; j < count; ++j) {
//                partialSum += input[i - j];
//            }
//
//            result[resultIdx++] = partialSum / count;
//        }
//
//        return result;
//    }

}
