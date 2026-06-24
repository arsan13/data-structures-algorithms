package tree.bst;

public class RecoverBSTOptimized {
    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;

    // T-O(N), S-O(1)
    public void recoverTree(TreeNode root) {
        first = prev = middle = last = null;

        inOrder(root);

        if (first != null && last != null) {
            swap(first, last); // Non adjacent elements violated
        } else if (first != null && middle != null) {
            swap(first, middle); // adjacent elements violated
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);

        if (prev != null && root.val < prev.val) {
            if (first == null) { // First violation
                first = prev;
                middle = root;
            } else { // Second violation
                last = root;
            }
        }

        prev = root;
        inOrder(root.right);
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
