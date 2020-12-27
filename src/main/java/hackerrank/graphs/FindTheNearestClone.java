package hackerrank.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
            nodes[i] = new CNode(ids[i]);
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
        start.distance = 0;

        while (!queue.isEmpty()) {
            final CNode polled = queue.poll();

            for (CNode n : polled.neighbors) {
                if (n.isNotVisited()) {
                    n.distance = polled.distance + 1;
                    if (start.color.equals(n.color)) return n.distance;
                    queue.offer(n);
                }
            }
        }

        return -1;
    }

    static class CNode {

        private final Long color;
        Integer distance = -1;
        private final List<CNode> neighbors = new ArrayList<>();

        CNode(Long color) {
            this.color = color;
        }

        void addNeighbors(CNode neighbor) {
            if (neighbors.contains(neighbor)) return;
            neighbors.add(neighbor);
            neighbor.neighbors.add(this);
        }

        boolean isNotVisited() {
            return distance.equals(-1);
        }

    }

}
