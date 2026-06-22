package tree.bst;

public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        int[] res = new int[1];

        kthSmallest(root, k, count, res);
        return res[0];
    }

    private void kthSmallest(TreeNode root, int k, int[] count, int[] res) {
        if (root == null) {
            return;
        }

        kthSmallest(root.left, k, count, res);

        count[0]++;
        if (count[0] == k) {
            res[0] = root.val;
            return;
        }

        kthSmallest(root.right, k, count, res);
    }
}
