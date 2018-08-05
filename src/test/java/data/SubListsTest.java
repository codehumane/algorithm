package data;

import lombok.val;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SubListsTest {

    @Test
    public void of() throws Exception {

        // when
        val subLists = SubLists.of(asList("1", "2", "3")).collect(toSet());

        // then
        assertEquals(7, subLists.size());
        assertTrue(subLists.contains(new ArrayList<String>()));
        assertTrue(subLists.contains(singletonList("1")));
        assertTrue(subLists.contains(asList("1", "2")));
        assertTrue(subLists.contains(singletonList("2")));
        assertTrue(subLists.contains(asList("1", "2", "3")));
        assertTrue(subLists.contains(asList("2", "3")));
        assertTrue(subLists.contains(singletonList("3")));
    }
}