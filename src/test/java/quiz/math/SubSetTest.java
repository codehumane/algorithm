package quiz.math;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import quiz.math.SubSet;

import java.util.Set;

public class SubSetTest {

    @Test
    public void make_원소가_3개이고_부분집합의_크기를_2로_설정한_경우() throws Exception {
        // Given
        SubSet subSet = new SubSet();
        Set<Set<Integer>> expected = Sets.newHashSet();
        expected.add(Sets.newHashSet(1, 2));
        expected.add(Sets.newHashSet(1, 3));
        expected.add(Sets.newHashSet(2, 3));

        // When
        Set<Set<Integer>> result = subSet.make(3, 2);

        // Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void make_원소가_4개이고_부분집합의_크기를_2로_설정한_경우() throws Exception {
        // Given
        SubSet subSet = new SubSet();
        Set<Set<Integer>> expected = Sets.newHashSet();
        expected.add(Sets.newHashSet(1, 2));
        expected.add(Sets.newHashSet(1, 3));
        expected.add(Sets.newHashSet(1, 4));
        expected.add(Sets.newHashSet(2, 3));
        expected.add(Sets.newHashSet(2, 4));
        expected.add(Sets.newHashSet(3, 4));

        // When
        Set<Set<Integer>> result = subSet.make(4, 2);

        // Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void make_원소가_4개이고_부분집합의_크기를_3으로_설정한_경우() throws Exception {
        // Given
        SubSet subSet = new SubSet();
        Set<Set<Integer>> expected = Sets.newHashSet();
        expected.add(Sets.newHashSet(1, 2, 3));
        expected.add(Sets.newHashSet(1, 2, 4));
        expected.add(Sets.newHashSet(1, 3, 4));
        expected.add(Sets.newHashSet(2, 3, 4));

        // When
        Set<Set<Integer>> result = subSet.make(4, 3);

        // Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void make_원소가_5개이고_부분집합의_크기를_3으로_설정한_경우() throws Exception {
        // Given
        SubSet subSet = new SubSet();
        Set<Set<Integer>> expected = Sets.newHashSet();
        expected.add(Sets.newHashSet(1, 2, 3));
        expected.add(Sets.newHashSet(1, 2, 4));
        expected.add(Sets.newHashSet(1, 2, 5));
        expected.add(Sets.newHashSet(1, 3, 4));
        expected.add(Sets.newHashSet(1, 3, 5));
        expected.add(Sets.newHashSet(1, 4, 5));
        expected.add(Sets.newHashSet(2, 3, 4));
        expected.add(Sets.newHashSet(2, 3, 5));
        expected.add(Sets.newHashSet(2, 4, 5));
        expected.add(Sets.newHashSet(3, 4, 5));

        // When
        Set<Set<Integer>> result = subSet.make(5, 3);

        // Then
        Assertions.assertEquals(expected, result);
    }
}
