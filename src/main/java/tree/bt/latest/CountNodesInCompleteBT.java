package tree.bt.latest;

public class CountNodesInCompleteBT {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        if (lh == rh) {
            return ((2<<lh) - 1); // 2 to power lh/rh - 1
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode root) {
        int c = 0;
        while(root.left != null) {
            c++;
            root = root.left;
        }
        return c;
    }

    private int getRightHeight(TreeNode root) {
        int c = 0;
        while(root.right != null) {
            c++;
            root = root.right;
        }
        return c;
    }
}
