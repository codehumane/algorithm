package data.list;

import java.util.AbstractList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;

/**
 * Effective Java, 3rd Edition의 Item 47에서 발췌
 */
public class SubLists {

    /**
     * 책에서는 코드가 나오지 않았지만, `AbstractList`를 반환하는 버전은 이렇게 구현되지 않았을까 추정하고 만들어 봄. <br/>
     * Stream 반환 버전과 다르게, O(n^2)가 되지 않게 함. O(n)으로 개선.
     */
    static <E> List<List<E>> listOf(List<E> source) {

        return new AbstractList<List<E>>() {

            @Override
            public List<E> get(int index) {
                if (index >= this.size()) throw new IllegalArgumentException();
                if (index == 0) return emptyList();

                return IntStream
                        .rangeClosed(1, source.size())
                        .map(size -> size - 1)
                        .filter(prefixIndexInRangeFilter(index))
                        .boxed()
                        .findFirst()
                        .map(makeSubList(index))
                        .orElseThrow(IllegalArgumentException::new);
            }

            private IntPredicate prefixIndexInRangeFilter(int index) {
                return sourceIndex -> index >= countSubListSize(sourceIndex) &&
                        index < countSubListSize(sourceIndex + 1);
            }

            private Function<Integer, List<E>> makeSubList(int index) {
                return sourceIndex -> source
                        .subList(index - countSubListSize(sourceIndex), sourceIndex + 1);
            }

            @Override
            public int size() {
                return countSubListSize(source.size());
            }

            private int countSubListSize(int n) {
                return (n * (n + 1)) / 2 + 1;
            }
        };
    }

    static <E> Stream<List<E>> streamOf(List<E> list) {
        return Stream.concat(Stream.of(emptyList()), prefixes(list).flatMap(SubLists::suffixes));
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
