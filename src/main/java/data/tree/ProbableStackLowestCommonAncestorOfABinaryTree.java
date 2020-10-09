package data.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class ProbableStackLowestCommonAncestorOfABinaryTree implements LowestCommonAncestorOfABinaryTree {

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode lca = null;
        final Deque<NodeState> stack = new ArrayDeque<>();
        stack.push(new NodeState(root));

        while (!stack.isEmpty()) {
            final NodeState ns = stack.peek(); // do not pop

            switch (ns.state) {
                case BP:
                    if (ns.node == p || ns.node == q) {
                        if (lca == null) {
                            lca = ns.node;
                        } else {
                            return lca;
                        }
                    }

                    ns.state = NodeState.State.LD;
                    if (ns.node.left != null) {
                        stack.push(new NodeState(ns.node.left));
                    }

                    break;
                case LD:
                    ns.state = NodeState.State.BD;
                    if (ns.node.right != null) {
                        stack.push(new NodeState(ns.node.right));
                    }

                    break;
                default:
                    if (lca == stack.pop().node && stack.peek() != null) {
                        lca = stack.peek().node;
                    }

                    break;
            }
        }

        throw new IllegalStateException();
    }

    static class NodeState {

        final TreeNode node;
        State state;

        NodeState(TreeNode node) {
            this.node = node;
            this.state = State.BP;
        }

        enum State {
            BP, // Both Pending
            LD, // Left Done
            BD  // Both Done
        }
    }

}
