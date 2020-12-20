package data.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;

@Slf4j
public class FindKClosestElementsTest {

    private final FindKClosestElements closest = new FindKClosestElements();

    @Test
    public void example1() {
        final int[] arr = {1, 2, 3, 4, 5};
        final List<Integer> expected = newArrayList(1, 2, 3, 4);
        final List<Integer> result = closest.findClosestElements(arr, 4, 3);
        assertEquals(expected, result);
    }

    @Test
    public void example2() {
        final int[] arr = {1, 2, 3, 4, 5};
        final List<Integer> expected = newArrayList(1, 2, 3, 4);
        final List<Integer> result = closest.findClosestElements(arr, 4, -1);
        assertEquals(expected, result);
    }

    @Test
    public void failed1() {
        final int[] arr = {1, 1, 1, 10, 10, 10};
        final List<Integer> expected = newArrayList(10);
        final List<Integer> result = closest.findClosestElements(arr, 1, 9);
        assertEquals(expected, result);
    }

    @Test
    public void failed2() {
        final int[] arr = {0, 1, 1, 1, 2, 3, 6, 7, 8, 9};
        final List<Integer> expected = newArrayList(0, 1, 1, 1, 2, 3, 6, 7, 8);
        final List<Integer> result = closest.findClosestElements(arr, 9, 4);
        assertEquals(expected, result);
    }

    @Test
    public void failed3() {
        final int[] arr = {0, 0, 0, 1, 3, 5, 6, 7, 8, 8};
        final List<Integer> expected = newArrayList(1, 3);
        final List<Integer> result = closest.findClosestElements(arr, 2, 2);
        assertEquals(expected, result);
    }

    @Test
    public void search() {
        final int[] arr = {1, 2, 3, 4, 5};
        assertEquals(0, closest.search(arr, -1, 0, 4));
        assertEquals(0, closest.search(arr, 0, 0, 4));
        assertEquals(0, closest.search(arr, 1, 0, 4));
        assertEquals(1, closest.search(arr, 2, 0, 4));
        assertEquals(2, closest.search(arr, 3, 0, 4));
        assertEquals(3, closest.search(arr, 4, 0, 4));
        assertEquals(4, closest.search(arr, 5, 0, 4));
        assertEquals(4, closest.search(arr, 6, 0, 4));

        final int[] arr2 = {1, 3, 5, 9, 11};
        assertEquals(0, closest.search(arr2, -1, 0, 4));
        assertEquals(0, closest.search(arr2, 0, 0, 4));
        assertEquals(0, closest.search(arr2, 1, 0, 4));
        assertEquals(0, closest.search(arr2, 2, 0, 4));
        assertEquals(1, closest.search(arr2, 3, 0, 4));
        assertEquals(1, closest.search(arr2, 4, 0, 4));
        assertEquals(2, closest.search(arr2, 5, 0, 4));
        assertEquals(2, closest.search(arr2, 6, 0, 4));
        assertEquals(2, closest.search(arr2, 7, 0, 4));
        assertEquals(3, closest.search(arr2, 8, 0, 4));
        assertEquals(3, closest.search(arr2, 9, 0, 4));
        assertEquals(3, closest.search(arr2, 10, 0, 4));
        assertEquals(4, closest.search(arr2, 11, 0, 4));
        assertEquals(4, closest.search(arr2, 12, 0, 4));

        final int[] arr3 = {1, 1, 1, 5, 5};
        assertEquals(0, closest.search(arr3, -1, 0, 4));
        assertEquals(0, closest.search(arr3, 0, 0, 4));
        assertEquals(2, closest.search(arr3, 1, 0, 4));
        assertEquals(2, closest.search(arr3, 2, 0, 4));
        assertEquals(2, closest.search(arr3, 3, 0, 4));
        assertEquals(3, closest.search(arr3, 4, 0, 4));
        assertEquals(4, closest.search(arr3, 5, 0, 4));
        assertEquals(4, closest.search(arr3, 6, 0, 4));

        final int[] arr4 = {1, 1, 1, 10, 10, 10};
        assertEquals(3, closest.search(arr4, 9, 0, 5));
        assertEquals(5, closest.search(arr4, 10, 0, 5));
    }

    @Test
    public void extract() {
        final int[] arr = {1, 2, 3, 4, 5};
        assertEquals(newArrayList(1), closest.extract(arr, 1, 0, 1));
        assertEquals(newArrayList(1, 2), closest.extract(arr, 1, 0, 2));
        assertEquals(newArrayList(1, 2, 3), closest.extract(arr, 1, 0, 3));
        assertEquals(newArrayList(1, 2, 3, 4), closest.extract(arr, 1, 1, 4));
        assertEquals(newArrayList(1, 2, 3, 4, 5), closest.extract(arr, 1, 1, 5));
        assertEquals(newArrayList(2), closest.extract(arr, 1, 1, 1));
        assertEquals(newArrayList(1, 2), closest.extract(arr, 1, 1, 2));
        assertEquals(newArrayList(1, 2, 3), closest.extract(arr, 1, 1, 3));
        assertEquals(newArrayList(1, 2, 3, 4), closest.extract(arr, 1, 1, 4));
        assertEquals(newArrayList(1, 2, 3, 4, 5), closest.extract(arr, 1, 1, 5));
        assertEquals(newArrayList(3), closest.extract(arr, 2, 2, 1));
        assertEquals(newArrayList(2, 3), closest.extract(arr, 2, 2, 2));
        assertEquals(newArrayList(1, 2, 3), closest.extract(arr, 2, 2, 3));
        assertEquals(newArrayList(1, 2, 3, 4), closest.extract(arr, 2, 2, 4));
        assertEquals(newArrayList(1, 2, 3, 4, 5), closest.extract(arr, 2, 2, 5));

        final int[] arr2 = {1, 1, 1, 10, 10, 10};
        assertEquals(newArrayList(1), closest.extract(arr2, 2, 2, 1));
        assertEquals(newArrayList(1, 1), closest.extract(arr2, 2, 2, 2));
        assertEquals(newArrayList(1, 1, 1), closest.extract(arr2, 2, 2, 3));
        assertEquals(newArrayList(1, 1, 1, 10), closest.extract(arr2, 2, 2, 4));
        assertEquals(newArrayList(1, 1, 1, 10, 10), closest.extract(arr2, 2, 2, 5));
        assertEquals(newArrayList(1, 1, 1, 10, 10, 10), closest.extract(arr2, 2, 2, 6));
        assertEquals(newArrayList(10), closest.extract(arr2, 10, 5, 1));
        assertEquals(newArrayList(10, 10), closest.extract(arr2, 10, 5, 2));
        assertEquals(newArrayList(10, 10, 10), closest.extract(arr2, 10, 5, 3));

        final int[] arr3 = {0, 1, 1, 1, 2, 3, 6, 7, 8, 9};
        final List<Integer> result = closest.extract(arr3, 3, 5, 9);
        assertEquals(newArrayList(0, 1, 1, 1, 2, 3, 6, 7, 8), result);
    }

}