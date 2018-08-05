package data;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Effective Java, 3rd Edition의 Item 47에서 발췌
 */
@Slf4j
public class PowerSet {

    public static <E> List<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);
        if (src.size() > 30)
            throw new IllegalArgumentException("Set too big " + s);

        return new AbstractList<Set<E>>() {

            @Override
            public int size() {
                return 1 << src.size(); // 2 to the power srcSize
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set) o);
            }

            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    System.out.println(String.valueOf(index));
                    if ((index & 1) == 1)
                        result.add(src.get(i));
                }

                return result;
            }
        };
    }
}
