package data.set;

import com.google.common.collect.Sets;
import data.set.PowerSet;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PowerSetTest {

    @Test
    public void name() throws Exception {
        final List<Set<String>> powerSet = PowerSet.of(Sets.newHashSet("a", "b", "c"));
        assertEquals(8, powerSet.size());
        assertTrue(powerSet.get(0).isEmpty());
        assertEquals(Sets.newHashSet("a"), powerSet.get(1));
        assertEquals(Sets.newHashSet("b"), powerSet.get(2));
        assertEquals(Sets.newHashSet("a", "b"), powerSet.get(3));
        assertEquals(Sets.newHashSet("c"), powerSet.get(4));
        assertEquals(Sets.newHashSet("a", "c"), powerSet.get(5));
        assertEquals(Sets.newHashSet("b", "c"), powerSet.get(6));
        assertEquals(Sets.newHashSet("a", "b", "c"), powerSet.get(7));
    }
}