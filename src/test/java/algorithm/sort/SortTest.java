package algorithm.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.google.common.collect.Lists;

@Slf4j
@RunWith(value = Parameterized.class)
public class SortTest<T extends Sort> {

    private T sort;
    private Class<T> sortClass;

    private static final int[] bigList;
    private static final int BIG_LIST_SIZE = 1000000;

    static {
        bigList = new int[BIG_LIST_SIZE];
        for (int i = 0; i < bigList.length; i++) {
            bigList[i] = new Random().nextInt(10000);
        }
    }

    public SortTest(Class<T> sortClass) {
        this.sortClass = sortClass;
    }

    @Parameterized.Parameters
    public static List<Class> sortClasses() {
        List<Class> classes = new ArrayList<>();
        classes.add(BubbleSort.class);
        classes.add(SelectionSort.class);
        classes.add(InsertionSort.class);
        classes.add(ParallelMergeSort.class);
        classes.add(MergeSort.class);
        classes.add(QuickSort.class);
        return classes;
    }

    @Before
    public void setup() throws IllegalAccessException, InstantiationException {
        this.sort = sortClass.newInstance();
    }

    @Test
    public void sort_숫자가_하나만_주어진_경우_그대로_반환() throws Exception {
        // Given
        int[] list = {3};

        // When
        sort.sort(list);

        // Then
        int[] expected = {3};
        Assert.assertArrayEquals(expected, list);
    }

    @Test
    public void sort_역순으로_주어진_경우_정렬해서_반환() throws Exception {
        // Given
        int[] list = {3, 2, 1};

        // When
        sort.sort(list);

        // Then
        int[] expected = {1, 2, 3};
        Assert.assertArrayEquals(expected, list);
    }

    @Test
    public void sort_이미_정렬된_경우_그대로_반환() throws Exception {
        // Given
        int[] list = {1, 2, 3};

        // When
        sort.sort(list);

        // Then
        int[] expected = {1, 2, 3};
        Assert.assertArrayEquals(expected, list);
    }

    @Test
    public void sort_순서_뒤죽박죽인_긴_배열() throws Exception {
        // Given
        int[] list = {3, 1, 5, 8, 7, 6, 2, 4};

        // When
        sort.sort(list);

        // Then
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        Assert.assertArrayEquals(expected, list);
    }

    @Test
    public void sort_큰_배열() throws Exception {
        sort.sort(bigList);
    }
}
