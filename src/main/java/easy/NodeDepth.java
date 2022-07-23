package easy;

import java.util.Stack;

public class NodeDepth {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(15);
        root.right = new BinaryTree(20);
        root.left.right = new BinaryTree(15);
        root.right.left = new BinaryTree(20);
        System.out.println(nodeDepths(root));
        System.out.println(nodeDepthsIterative(root));

    }

    private static int nodeDepthsIterative(BinaryTree root) {
        int sum = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, 0));
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.tree == null)
                continue;
            sum += current.depth;
            stack.push(new Node(current.tree.left, current.depth + 1));
            stack.push(new Node(current.tree.right, current.depth + 1));
        }
        return sum;
    }

    public static int nodeDepths(BinaryTree root) {
        return dfs(root, 0);
    }

    private static int dfs(BinaryTree root, int nodeSum) {
        if (root == null)
            return 0;
        return nodeSum + dfs(root.left, nodeSum + 1) + dfs(root.right, nodeSum + 1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    static class Node {
        int depth;
        BinaryTree tree;
        public Node(BinaryTree tree, int depth) {
            this.tree = tree;
            this.depth = depth;
        }
    }
}
