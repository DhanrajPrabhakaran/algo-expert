package easy;

public class ClosestBST {
    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(5);
        tree.right = new BST (15);
        System.out.println("Closest BST: " + closestBST(tree, 5));
    }

    private static boolean closestBST(BST root, int target) {
        return dfs(root, target);
    }

    private static boolean dfs(BST root, int target) {
        if (root == null) return false;
        if (root.value == target) {
            return true;
        }
        return dfs(root.left, target) || dfs(root.right, target);
    }

    static class BST {
        int value;
        BST left;
        BST right;
        public BST(int value) {
            this.value = value;
        }
    }
}
