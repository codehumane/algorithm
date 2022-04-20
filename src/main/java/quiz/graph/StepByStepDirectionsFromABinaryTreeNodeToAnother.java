package quiz.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 * <p>
 * 여기 풀이에서 좀 더 나아가면 3(N)으로도 가능.
 * 처음에 N으로 LCA 찾고, 이 LCA로부터 startValue, destValue 찾아가며 경로 기록하면 됨.
 * 3N 풀이는 아래 링크 참고.
 * https://www.geeksforgeeks.org/step-by-step-shortest-path-from-source-node-to-destination-node-in-a-binary-tree/
 */
public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        var first = new FirstApproach().getDirections(root, startValue, destValue);
        var efficient = new MoreEfficient().getDirections(root, startValue, destValue);
        assert first.equals(efficient);
        return efficient;
    }

    static class MoreEfficient {
        public String getDirections(TreeNode root, int startValue, int destValue) {
            var lcp = findLCP(root, startValue, destValue);
            return toDirections(startValue, destValue, lcp);
        }

        TreeNode findLCP(TreeNode me, int start, int dest) {
            if (me == null) return null;

            var left = findLCP(me.left, start, dest);
            var right = findLCP(me.right, start, dest);

            if ((left != null && right != null)
                    || me.val == start
                    || me.val == dest) {
                return me;
            }

            return (left != null) ? left : right;
        }

        private String toDirections(int startValue, int destValue, TreeNode lcp) {
            var start = reversedPath(lcp, startValue)
                    .chars()
                    .mapToObj(x -> "U")
                    .collect(Collectors.joining());

            var dest = reversedPath(lcp, destValue)
                    .reverse()
                    .toString();

            return start.concat(dest);
        }

        private StringBuilder reversedPath(TreeNode from, int to) {
            if (from == null) return null;
            if (from.val == to) return new StringBuilder();

            var l = reversedPath(from.left, to);
            var r = reversedPath(from.right, to);

            if (l != null) return l.append("L");
            if (r != null) return r.append("R");

            return null;
        }
    }

    static class FirstApproach {
        public String getDirections(TreeNode root, int startValue, int destValue) {

            // 1. 두 값에 대해 dfs (w/ 경로 저장) -> S, D
            // 2. S reverse -> S_REVERSED
            // 3. D 값들을 set으로 저장 -> D_SET
            // 4. S_REVERSED 순회하며 D_SET에 포함된 첫 번째 값 찾기 -> LCP
            // 5. S_REVERSED 순회를 LCP까지 한 경로 + D 순회를 LCP까지 한 경로

            var SR = pathReversed(root, startValue);
            var D = pathReversed(root, destValue);
            Collections.reverse(D);

            var LCP = findLCP(SR, D);
            var P = getShortestPath(SR, D, LCP);
            return toDirections(P);
        }

        private List<TreeNode> pathReversed(TreeNode me, int to) {
            if (me == null) return null;

            if (me.val == to) {
                var path = new ArrayList<TreeNode>();
                path.add(me);
                return path;
            }

            var left = pathReversed(me.left, to);
            if (left != null) {
                left.add(me);
                return left;
            }

            var right = pathReversed(me.right, to);
            if (right != null) {
                right.add(me);
                return right;
            }

            return null;
        }

        private TreeNode findLCP(List<TreeNode> SR, List<TreeNode> D) {
            var SET = new HashSet<>(D);
            for (TreeNode N : SR) {
                if (SET.contains(N)) {
                    return N;
                }
            }

            throw new IllegalStateException();
        }

        private List<TreeNode> getShortestPath(List<TreeNode> SR, List<TreeNode> D, TreeNode LCP) {
            var path = new ArrayList<TreeNode>();

            for (int i = 0; i < SR.indexOf(LCP); i++) {
                path.add(SR.get(i));
            }

            path.add(LCP);

            for (int i = D.indexOf(LCP) + 1; i < D.size(); i++) {
                path.add(D.get(i));
            }

            return path;
        }

        private String toDirections(List<TreeNode> path) {
            var directions = new StringBuilder();

            for (int i = 0; i < path.size() - 1; i++) {
                var direction = getDirection(path.get(i), path.get(i + 1));
                directions.append(direction);
            }

            return directions.toString();
        }

        private String getDirection(TreeNode from, TreeNode to) {
            if (from.left == to) return "L";
            else if (from.right == to) return "R";
            else return "U";
        }
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

}
