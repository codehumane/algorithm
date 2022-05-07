package quiz.etc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductOfTheLastNumbersTest {

    @Test
    void example1() {
        var solution = new ProductOfTheLastNumbers();

        solution.add(3); // [3]
        solution.add(0); // [3,0]
        solution.add(2); // [3,0,2]
        solution.add(5); // [3,0,2,5]
        solution.add(4); // [3,0,2,5,4]

        assertEquals(20, solution.getProduct(2), "The product of the last 2 numbers is 5 * 4 = 20");
        assertEquals(40, solution.getProduct(3), "The product of the last 3 numbers is 2 * 5 * 4 = 40");
        assertEquals(0, solution.getProduct(4), "The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0");
        assertEquals(0, solution.getProduct(5));

        solution.add(8); // [3,0,2,5,4,8]

        assertEquals(32, solution.getProduct(2), "The product of the last 2 numbers is 4 * 8 = 32");
    }

    @Test
    void custom1() {
        var solution = new ProductOfTheLastNumbers();

        solution.add(5);
        solution.add(4);
        solution.add(1);
        solution.add(1);
        solution.add(1);
        solution.add(1);

        assertEquals(1, solution.getProduct(1));
        assertEquals(1, solution.getProduct(2));
        assertEquals(1, solution.getProduct(3));
        assertEquals(1, solution.getProduct(4));
        assertEquals(4, solution.getProduct(5));
        assertEquals(20, solution.getProduct(6));
    }

}