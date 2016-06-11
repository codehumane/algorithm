package data;

import data.BitSet;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class BitSetTest {

    @Test
    public void set() throws Exception {
        // Given
        BitSet set = new BitSet(8);

        // When
        set.set(0);
        set.set(6);

        // Then
        Assert.assertEquals("01000001", set.toString());
    }

    @Test
    public void clear() throws Exception {
        // Given
        BitSet set = new BitSet(8);
        set.set(2);
        set.set(4);

        // When
        set.clear(2);
        set.clear(3);

        // Then
        Assert.assertEquals("00010000", set.toString());
    }

    @Test
    public void toggle() throws Exception {
        // Given
        BitSet set = new BitSet(8);
        set.set(7);
        set.set(4);
        set.set(0);

        // When
        set.toggle(3);
        set.toggle(0);

        // Then
        Assert.assertEquals("10011000", set.toString());
    }

    @Test
    public void full() throws Exception {
        // Given
        BitSet set = new BitSet(20);

        // When
        set.full();

        // Then
        Assert.assertEquals(20, set.count());
    }

    @Test
    public void empty() throws Exception {
        // Given
        BitSet set = new BitSet(20);

        // When
        set.empty();

        // Then
        Assert.assertEquals(0, set.count());
    }

    @Test
    public void union() throws Exception {
        // Given
        BitSet set = new BitSet(8);
        set.set(7);
        set.set(6);
        set.set(4);
        set.set(0);

        BitSet source = new BitSet(8);
        source.set(7);
        source.set(5);

        // When
        set.union(source);

        // Then
        Assert.assertEquals("11110001", set.toString());
    }

    @Test
    public void intersect() throws Exception {
        // Given
        BitSet set = new BitSet(8); // 11010001
        set.set(7);
        set.set(6);
        set.set(4);
        set.set(0);

        BitSet source = new BitSet(8); // 10100000
        source.set(7);
        source.set(5);

        // When
        set.intersect(source);

        // Then
        Assert.assertEquals("10000000", set.toString());
    }

    @Test
    public void difference() throws Exception {
        // Given
        BitSet set = new BitSet(8); // 11010001
        set.set(7);
        set.set(6);
        set.set(4);
        set.set(0);

        BitSet source = new BitSet(8); // 10100000
        source.set(7);
        source.set(5);

        // When
        set.difference(source);

        // Then
        Assert.assertEquals("01010001", set.toString());
    }

    @Test
    public void getSubsets() throws Exception {
        // Given
        BitSet set = new BitSet(8);
        set.set(7);
        set.set(2);
        set.set(1);

        // When
        Set subsets = set.getSubsets();

        // Then
        Assert.assertEquals(7, subsets.size());
        Assert.assertTrue(subsets.contains(128 + 0 + 0 + 0 + 0 + 4 + 2 + 0));
        Assert.assertTrue(subsets.contains(128 + 0 + 0 + 0 + 0 + 4 + 0 + 0));
        Assert.assertTrue(subsets.contains(128 + 0 + 0 + 0 + 0 + 0 + 2 + 0));
        Assert.assertTrue(subsets.contains(128 + 0 + 0 + 0 + 0 + 0 + 0 + 0));
        Assert.assertTrue(subsets.contains(0 + 0 + 0 + 0 + 0 + 4 + 2 + 0));
        Assert.assertTrue(subsets.contains(0 + 0 + 0 + 0 + 0 + 4 + 0 + 0));
        Assert.assertTrue(subsets.contains(0 + 0 + 0 + 0 + 0 + 0 + 2 + 0));
    }

    @Test
    public void equals_레퍼런스가_같으_경우는_참() throws Exception {
        // Given
        BitSet set = new BitSet(20);

        // Then
        Assert.assertTrue(set.equals(set));
    }

    @Test
    public void equals_비트는_동일한데_capacity가_다른_경우는_거짓() throws Exception {
        // Given
        BitSet set = new BitSet(20);
        set.set(3);

        BitSet target = new BitSet(10);
        target.set(3);

        // Then
        Assert.assertFalse(set.equals(target));
    }

    @Test
    public void equals_비트와_capacity_모두_같은_경우는_참() throws Exception {
        // Given
        BitSet set = new BitSet(20);
        set.set(3);
        set.set(5);

        BitSet target = new BitSet(20);
        target.set(3);
        target.set(5);

        // Then
        Assert.assertTrue(set.equals(target));
    }

    @Test
    public void firstSetIndex_00010101인_경우() throws Exception {
        // Given
        BitSet set = new BitSet(8);
        set.set(4);
        set.set(2);
        set.set(0);

        // When
        int index = set.firstSetIndex();

        // Then
        Assert.assertEquals(4, index);
    }

    @Test
    public void firstSetIndex_0000111인_경우() throws Exception {
        // Given
        BitSet set = new BitSet(8);
        set.set(2);
        set.set(1);
        set.set(0);

        // When
        int index = set.firstSetIndex();

        // Then
        Assert.assertEquals(2, index);
    }

    @Test
    public void firstSetIndex_00000001인_경우() throws Exception {
        // Given
        BitSet set = new BitSet(8);
        set.set(0);

        // When
        int index = set.firstSetIndex();

        // Then
        Assert.assertEquals(0, index);
    }

    @Test
    public void firstSetIndex_00000000인_경우() throws Exception {
        // Given
        BitSet set = new BitSet(8);

        // When
        int index = set.firstSetIndex();

        // Then
        Assert.assertEquals(0, index);
    }

    @Test
    public void lastSetIndex_00010101인_경우() throws Exception {
        // Given
        BitSet set = new BitSet(8);
        set.set(4);
        set.set(2);
        set.set(0);

        // When
        int index = set.lastSetIndex();

        // Then
        Assert.assertEquals(0, index);
    }

    @Test
    public void lastSetIndex_10000000인_경우() throws Exception {
        // Given
        BitSet set = new BitSet(8);
        set.set(7);

        // When
        int index = set.lastSetIndex();

        // Then
        Assert.assertEquals(7, index);
    }

    @Test
    public void lastSetIndex_10100000인_경우() throws Exception {
        // Given
        BitSet set = new BitSet(8);
        set.set(7);
        set.set(5);

        // When
        int index = set.lastSetIndex();

        // Then
        Assert.assertEquals(5, index);
    }

    @Test
    public void test() {
        Set<Man> set = new HashSet<Man>();
        Man a = new Man("a");
        Man b = new Man("b");
        set.add(a);
//        a.setName("b");
        set.remove(a);
        Assert.assertEquals(0, set.size());
    }

    @Getter
    @Setter
    class Man {

        private String name;

        Man(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Man target = (Man) o;
            return name != null ? name.equals(target.name) : target.name == null;

        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }
}
