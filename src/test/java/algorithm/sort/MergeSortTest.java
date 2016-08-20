package algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RunWith(value = Parameterized.class)
public class MergeSortTest<T extends Sort> {

    private T sort;
    private Class<T> sortClass;
    private static final int[] list;

    /**
     * List size is a factor affecting on sort performance. The bigger size makes parallel merge sort performance
     * better.
     */
    private static final int LIST_SIZE = 10000;

    static {
        list = new int[LIST_SIZE];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Random().nextInt(10000);
        }
    }

    public MergeSortTest(Class<T> sortClass) {
        this.sortClass = sortClass;
    }

    @Parameterized.Parameters
    public static List<Class> sortClasses() {
        List<Class> classes = new ArrayList<>();
        classes.add(ParallelMergeSort.class);
        classes.add(MergeSort.class);
        return classes;
    }

    @Before
    public void setup() throws IllegalAccessException, InstantiationException {
        this.sort = sortClass.newInstance();
    }

    @Test
    public void sort() throws Exception {
        new ParallelMergeSort().sort(list);
    }
}