package quiz.graph;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

/**
 * https://leetcode.com/problems/network-delay-time/
 */
public class NetworkDelayTime {

    public int solution(int[][] times, int n, int k) {
        List<Node> nodes = buildNodes(times, n);
        Node start = nodes.get(k - 1);
//        dfs(start, 0);
//        wrongDijkstra(start);
        dijkstra(start, nodes);

        // 방문되지 않은 노드가 있다면 -1 반환
        if (nodes.stream().anyMatch(x -> !x.visited)) return -1;

        return nodes
                .stream()
                .mapToInt(x -> x.delay)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    private void dijkstra(Node start, List<Node> nodes) {
        nodes.forEach(n -> n.delay = Integer.MAX_VALUE);
        start.delay = 0;

        while (true) {
            Optional<Node> min = nodes
                    .stream()
                    .filter(n -> !n.visited)
                    .min(comparingInt(o -> o.delay));

            if (!min.isPresent()) return;
            if (min.get().delay == Integer.MAX_VALUE) return;

            Node node = min.get();
            node.visited = true;

            node.targets.forEach((t, w) -> {
                if (!t.visited && t.delay > node.delay + w) {
                    t.delay = node.delay + w;
                }
            });
        }
    }

    private void wrongDijkstra(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        root.visit(0);

        while (!deque.isEmpty()) {
            Node parent = deque.poll();

            for (Map.Entry<Node, Integer> e : parent.targets.entrySet()) {
                Node child = e.getKey();
                int weight = e.getValue();

                if (child.isVisitable(parent.delay + weight)) {
                    child.visit(parent.delay + weight);
                    deque.offer(child);
                }
            }
        }
    }

    private void dfs(Node node, int delay) {
        node.visit(delay);

        for (Map.Entry<Node, Integer> entry : node.targets.entrySet()) {
            Node target = entry.getKey();
            int weight = entry.getValue();

            if (target.isVisitable(weight + delay)) {
                dfs(target, weight + delay);
            }
        }
    }

    private List<Node> buildNodes(int[][] times, int n) {
        List<Node> nodes = IntStream
                .range(1, n + 1)
                .mapToObj(Node::new)
                .collect(toList());

        for (int[] time : times) {
            Node source = nodes.get(time[0] - 1);
            Node target = nodes.get(time[1] - 1);
            source.addTarget(target, time[2]);
        }

        return nodes;
    }

    static class Node {

        final int value;
        int delay = 0;
        boolean visited = false;
        Map<Node, Integer> targets = new HashMap<>();

        Node(int value) {
            this.value = value;
        }

        void addTarget(Node target, int weight) {
            targets.put(target, weight);
        }

        public void visit(int delay) {
            visited = true;
            this.delay = delay;
        }

        boolean isVisitable(int delayCandidate) {
            if (!visited) return true;
            return delay > delayCandidate;
        }
    }

}
