package tree.bst;

public class MaximumSumBST {
    int res = 0;

    public int maxSumBST(TreeNode root) {
        maxSumBSTUtil(root);
        return res;
    }

    private TreeData maxSumBSTUtil(TreeNode root) {
        if (root == null) {
            return new TreeData(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        TreeData leftData = maxSumBSTUtil(root.left);
        TreeData rightData = maxSumBSTUtil(root.right);

        if (leftData.maxValue < root.val && root.val < rightData.minValue) {
            // Valid BST
            int sum =  root.val + leftData.sum + rightData.sum;
            res = Math.max(res, sum);
            return new TreeData(
                    sum,
                    Math.min(leftData.minValue, root.val),
                    Math.max(rightData.maxValue, root.val)
            );
        }

        //Not a valid BST, make parent invalid BST
        return new TreeData(Math.max(leftData.sum, rightData.sum), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private record TreeData(int sum, int minValue, int maxValue) {
    }
}
