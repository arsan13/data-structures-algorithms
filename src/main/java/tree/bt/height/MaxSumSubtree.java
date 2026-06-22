package tree.bt.height;

//Given a binary tree, task is to find subtree with maximum sum in tree.
public class MaxSumSubtree {

	int sum = 0;

	public int maxSum(Node root) {
		maxSumUtil(root);
		return sum;
	}

	private int maxSumUtil(Node root) {
		if (root == null)
			return 0;

		int left = maxSumUtil(root.left);
		int right = maxSumUtil(root.right);

		int temp = root.data + left + right;
		sum = Math.max(sum, temp);
		return temp;
	}
}
