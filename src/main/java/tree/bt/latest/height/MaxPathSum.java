package tree.bt.latest.height;

public class MaxPathSum {

    public long maxPathSum(TreeNode root) {
        long[] maxSum = new long[1];
        maxSum[0] = Integer.MIN_VALUE;

        maxPathSumUtil(root, maxSum);

        return maxSum[0];
    }

    private long maxPathSumUtil(TreeNode root, long[] maxSum) {
        if (root == null) {
            return 0;
        }

        long lh = Math.max(0, maxPathSumUtil(root.left, maxSum));
        long rh = Math.max(0, maxPathSumUtil(root.right, maxSum));

        maxSum[0] = Math.max(root.data, root.data + lh + rh);

        return root.data + Math.max(lh, rh);
    }
}
