package hackerrank.graphs;

import java.util.*;

public class RoadsAndLibraries {

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        long totalCost = 0L;
        final List<CityNode> nodes = buildCityNodes(n, cities);

        for (CityNode node : nodes) {
            if (!node.visited) {
                int distance = bfs(node);
                totalCost += (c_road < c_lib) ? distance * c_road + c_lib : (distance + 1) * c_lib;
            }
        }

        return totalCost;
    }

    private static List<CityNode> buildCityNodes(Integer count, int[][] cities) {
        final Map<Integer, CityNode> nodes = new HashMap<>();

        for (int i = 0; i < count; i++) {
            nodes.put(i, new CityNode());
        }

        for (int[] link : cities) {
            final CityNode from = nodes.get(link[0] - 1);
            final CityNode to = nodes.get(link[1] - 1);
            from.addNeighbor(to);
        }

        return new ArrayList<>(nodes.values());
    }

    private static int bfs(CityNode root) {

        int distance = 0;
        final Queue<CityNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            final CityNode node = queue.poll();
            node.visited = true;

            for (CityNode neighbor : node.neighbors) {

                if (!neighbor.visited) {
                    distance++;
                    neighbor.visited = true;
                    queue.offer(neighbor);
                }

            }

        }

        return distance;
    }

    private static class CityNode {

        boolean visited = false;
        final Set<CityNode> neighbors = new HashSet<>();

        void addNeighbor(CityNode neighbor) {
            neighbors.add(neighbor);
            neighbor.neighbors.add(this);
        }

    }

}
