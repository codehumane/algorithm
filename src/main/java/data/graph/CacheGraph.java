package data.graph;

import java.io.Serializable;
import java.util.List;

//import org.springframework.cache.Cache;
//import org.springframework.cache.Cache.ValueWrapper;
//
//import com.google.common.collect.Lists;

/**
 * Cache를 그래프 형태로 관리
 *
 * edge: 간선 <br/>
 * vertex: 정점 (노드) <br/>
 *
 * @author chogh1211
 *
 */
public class CacheGraph<T> implements Serializable {

//    private static final long serialVersionUID = 1L;
//
//    /**
//     * 데이터 source
//     */
//    private final Cache cache;
//
//    public CacheGraph(Cache cache) {
//        this.cache = cache;
//    }
//
//    /**
//     * 간선 추가
//     *
//     * @param from
//     * @param to
//     * @return
//     */
//    public boolean addEdge(T from, T to) {
//        if (cache == null) {
//            return false;
//        }
//
//        boolean linkedTo = link(new CacheGraphVertex<T>(from), new CacheGraphVertex<T>(to));
//        boolean linkedFrom = link(new CacheGraphVertex<T>(to), new CacheGraphVertex<T>(from));
//
//        /**
//         * 캐시 만료 정책으로 인해 A → B 연결은 존재하지만 B → A로의 연결은 부재할 수 있다. <br/>
//         * 이에 따라 한쪽으로라도 연결이 이루어지면 연결 성공이라고 간주한다. <br/>
//         */
//        return linkedTo || linkedFrom;
//    }
//
//    @SuppressWarnings("unchecked")
//    private boolean link(CacheGraphVertex<T> from, CacheGraphVertex<T> to) {
//        ValueWrapper valueWrapper = cache.get(from);
//        List<CacheGraphVertex<T>> vertexes = Lists.newArrayList();
//        if (valueWrapper != null) {
//            vertexes = (List<CacheGraphVertex<T>>) valueWrapper.get();
//        }
//
//        if (vertexes.contains(to)) {
//            return false;
//        }
//
//        vertexes.add(to);
//        cache.put(from, vertexes);
//        return true;
//    }
//
//    /**
//     * 간선 제거
//     *
//     * @param from
//     * @param to
//     * @return
//     */
//    public boolean removeEdge(T from, T to) {
//        if (cache == null) {
//            return false;
//        }
//
//        boolean unlinked = unlink(new CacheGraphVertex<T>(from), new CacheGraphVertex<T>(to));
//        unlink(new CacheGraphVertex<T>(to), new CacheGraphVertex<T>(from));
//        return unlinked;
//    }
//
//    @SuppressWarnings("unchecked")
//    private boolean unlink(CacheGraphVertex<T> from, CacheGraphVertex<T> to) {
//        ValueWrapper valueWrapper = cache.get(from);
//        if (valueWrapper == null) {
//            return false;
//        }
//
//        List<CacheGraphVertex<T>> vertexes = (List<CacheGraphVertex<T>>) valueWrapper.get();
//        if (!vertexes.contains(to)) {
//            return false;
//        }
//
//        vertexes.remove(to);
//        if (!vertexes.isEmpty()) {
//            cache.put(from, vertexes);
//        } else {
//            cache.evict(from);
//        }
//
//        return true;
//    }
//
//    /**
//     * 인접 정점 모두 반환
//     *
//     * @param from
//     * @return
//     */
//    @SuppressWarnings("unchecked")
//    public List<T> getAdjacentVertexes(T from) {
//        if (cache == null) {
//            return Lists.newArrayList();
//        }
//
//        ValueWrapper valueWrapper = cache.get(new CacheGraphVertex<T>(from));
//        if (valueWrapper == null) {
//            return Lists.newArrayList();
//        }
//
//        List<T> list = Lists.newArrayList();
//        for (CacheGraphVertex<T> vertex : (List<CacheGraphVertex<T>>) valueWrapper.get()) {
//            list.add(vertex.getValue());
//        }
//
//        return list;
//    }

}
