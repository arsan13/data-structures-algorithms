package tree.bt.latest.height;

public class DiameterOfBinaryTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        //Brute force: For every node, calculate the height of left and right subtree and update diameter as max(max, lh + rh). Time O(n * n)

        //Optimized: Calculate diameter and height at the same time. Time O(n)
        diameterUtil(root);
        return diameter;
    }

    private int diameterUtil(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int lh = diameterUtil(root.left);
        int rh = diameterUtil(root.right);

        diameter = Math.max(diameter, lh + rh);

        return 1 + Math.max(lh, rh);
    }
}
