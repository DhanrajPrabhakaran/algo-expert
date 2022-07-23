package easy;

import java.util.*;

public class BranchSum {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public static class Branch {
        private BinaryTree tree;
        private int sum;
        Branch(BinaryTree tree, int sum) {
            this.tree = tree;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(15);
        root.right = new BinaryTree(20);
        System.out.println(branchSums(root));
    }
    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sum = new ArrayList<>();
        Stack<Branch> stack = new Stack<>();
        stack.add(new Branch(root, root.value));

        while (stack.size() > 0) {
            Branch current = stack.pop();
            if (current.tree.right != null)
                stack.add(new Branch(current.tree.right, current.sum + current.tree.right.value));
            if (current.tree.left != null)
                stack.add(new Branch(current.tree.left, current.sum + current.tree.left.value));
            if (current.tree.left == null && current.tree.right == null)
                sum.add(current.sum);
        }
        return sum;
    }
}
