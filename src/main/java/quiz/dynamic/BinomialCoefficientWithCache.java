package quiz.dynamic;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 이항 계수를 캐시를 사용하여 구현한다. 단순 분할 정복이 아닌 동적 계획법
 */
@Slf4j
public class BinomialCoefficientWithCache implements BinomialCoefficient {

    private Map<Integer, Map<Integer, Integer>> cache = Maps.newHashMap();

    @Override
    public int calculate(int N, int K) {
        Integer cached = getCached(N, K);
        if (cached != null) {
            return cached;
        }

        if (N == K || K == 0) {
            // base condition
            return 1;
        }

        int result = 0;
        result += calculate(N - 1, K);
        result += calculate(N - 1, K - 1);

        cache(N, K, result);

        return result;
    }

    private Integer getCached(int N, int K) {
        Map<Integer, Integer> cachedN = cache.get(N);
        if (cachedN == null) {
            return null;
        }

        return cachedN.get(K);
    }

    private void cache(int N, int K, int result) {
        Map<Integer, Integer> cachedN = cache.get(N);
        if (cachedN == null) {
            cachedN = Maps.newHashMap();
            cache.put(N, cachedN);
        }

        cache.get(N).put(K, result);
    }
}