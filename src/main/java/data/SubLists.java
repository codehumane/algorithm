package data;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Effective Java, 3rd Edition의 Item 47에서 발췌
 */
public class SubLists {

    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(
                Stream.of(Collections.emptyList()),
                prefixes(list).flatMap(SubLists::suffixes));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream
                .rangeClosed(1, list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    private static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream
                .range(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()));
    }
}
