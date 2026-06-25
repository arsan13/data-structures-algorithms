package tree.bst;

public class LargestBST {

    // Brute: O(N * N). For every node/subtree check if it is valid BST and determine size.
    public int largestBst(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return size(root);
        }
        return Math.max(largestBst(root.left), largestBst(root.right));
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    private int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
}
