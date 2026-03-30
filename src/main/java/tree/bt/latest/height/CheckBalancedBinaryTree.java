package tree.bt.latest.height;

public class CheckBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return isBalancedUtil(root) != -1;
    }

    private int isBalancedUtil(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int lh = isBalancedUtil(root.left);
        int rh = isBalancedUtil(root.right);

        if(lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }
}