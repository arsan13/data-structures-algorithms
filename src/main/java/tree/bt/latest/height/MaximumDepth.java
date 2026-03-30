package tree.bt.latest.height;

// Height of the BT
public class MaximumDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
