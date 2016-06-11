package quiz;

import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import com.google.common.collect.Sets;

@Slf4j
public class SubSet {

    /**
     * 1부터 n으로 이루어진 집합에서 주어진 크기로 만들 수 있는 모든 부분집합을 구하라.<br/>
     * <p/>
     * e.g <br/>
     * 만약 3과 2가 주어졌다면<br/>
     * 12, 13, 23이 되고,<br/>
     * 4와 2가 주어지면<br/>
     * 12, 13, 14, 23, 24, 34가 되며, 만약 5와 3이 주어졌다면<br/>
     * 123, 124, 125, 234, 235, 345가 된다.
     *
     * @param n
     * @param size
     */
    public Set<Set<Integer>> make(int n, int size) {
        Set<Set<Integer>> sets = Sets.newHashSet();
        addToSet(sets, Sets.<Integer>newHashSet(), size, 1, n);
        return sets;
    }

    private void addToSet(Set<Set<Integer>> sets, Set<Integer> set, int size, int from, int to) {
        for (int i = from; i <= to; i++) {

            Set<Integer> copied = Sets.newHashSet(set);
            copied.add(i);

            if (copied.size() == size) {
                sets.add(copied);
                continue;
            }

            addToSet(sets, copied, size, from + 1, to);
        }
    }

    public Set<Set<Integer>> makeByForStatement(int n, int size) {
        Set<Set<Integer>> sets = Sets.newHashSet();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    // size에 따라 점점 늘어나는 for 문 발생..
                    Set<Integer> set = Sets.newHashSet();
                    set.add(i);
                    set.add(j);
                    set.add(k);
                    sets.add(set);
                }
            }
        }

        return sets;
    }
}
