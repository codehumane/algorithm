package hackerrank.graphs;

import java.util.*;

public class FindTheNearestClone {

    static int findShortest(
            int graphNodes,
            int[] graphFrom,
            int[] graphTo,
            long[] ids,
            int val) {

        final CNode[] nodes = generateNodes(ids, graphFrom, graphTo);
        return findShortestColorMatchingDistance(nodes[val - 1]);
    }

    private static CNode[] generateNodes(
            long[] ids,
            int[] graphFrom,
            int[] graphTo) {

        final CNode[] nodes = new CNode[ids.length];
        for (int i = 0; i < ids.length; i++) {
            nodes[i] = new CNode(i + 1, ids[i]);
        }

        for (int i = 0; i < graphFrom.length; i++) {
            final CNode from = nodes[graphFrom[i] - 1];
            final CNode to = nodes[graphTo[i] - 1];
            from.addNeighbors(to);
        }

        return nodes;
    }

    private static int findShortestColorMatchingDistance(CNode start) {
        final Queue<CNode> queue = new ArrayDeque<>();
        queue.offer(start);
        start.setDistance(0);

        while (!queue.isEmpty()) {
            final CNode polled = queue.poll();

            for (CNode n : polled.getNeighbors()) {
                if (n.isNotVisited()) {
                    n.setDistance(polled.getDistance() + 1);
                    if (start.matchColor(n)) return n.getDistance();
                    queue.offer(n);
                }
            }
        }

        return -1;
    }

    static class CNode {

        private static final Integer INITIAL_DISTANCE = -1;
        private final Integer value;
        private final Long color;
        private Integer distance = INITIAL_DISTANCE;
        private final Set<CNode> neighbors = new HashSet<>();

        CNode(Integer value, Long color) {
            this.value = value;
            this.color = color;
        }

        void addNeighbors(CNode neighbor) {
            neighbors.add(neighbor);
            neighbor.neighbors.add(this);
        }

        Set<CNode> getNeighbors() {
            return neighbors;
        }

        void setDistance(Integer distance) {
            this.distance = distance;
        }

        Integer getDistance() {
            return distance;
        }

        boolean isNotVisited() {
            return distance.equals(INITIAL_DISTANCE);
        }

        boolean matchColor(CNode node) {
            return color.equals(node.color);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CNode cNode = (CNode) o;
            return Objects.equals(value, cNode.value);
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }
    }

}
