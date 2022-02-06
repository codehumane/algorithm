package data.list;

import data.list.SubLists;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubListsTest {

    @Test
    public void streamOf() throws Exception {

        // when
        val subLists = SubLists.streamOf(asList("1", "2", "3")).collect(toSet());

        // then
        assertEquals(7, subLists.size());
        assertTrue(subLists.contains(new ArrayList<String>()));
        assertTrue(subLists.contains(asList("1")));
        assertTrue(subLists.contains(asList("1", "2")));
        assertTrue(subLists.contains(asList("2")));
        assertTrue(subLists.contains(asList("1", "2", "3")));
        assertTrue(subLists.contains(asList("2", "3")));
        assertTrue(subLists.contains(asList("3")));
    }

    @Test
    public void listOf() throws Exception {

        // when
        val subLists = SubLists.listOf(asList("1", "2", "3", "4"));

        // then
        assertEquals(11, subLists.size());
        assertEquals(emptyList(), subLists.get(0));
        assertEquals(asList("1"), subLists.get(1));
        assertEquals(asList("1", "2"), subLists.get(2));
        assertEquals(asList("2"), subLists.get(3));
        assertEquals(asList("1", "2", "3"), subLists.get(4));
        assertEquals(asList("2", "3"), subLists.get(5));
        assertEquals(asList("3"), subLists.get(6));
        assertEquals(asList("1", "2", "3", "4"), subLists.get(7));
        assertEquals(asList("2", "3", "4"), subLists.get(8));
        assertEquals(asList("3", "4"), subLists.get(9));
        assertEquals(asList("4"), subLists.get(10));
    }
}