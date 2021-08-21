package dp.tree;

// Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.
public class MaxPathSum {

	int res;

	int findMaxSum(Node node) {
		res = Integer.MIN_VALUE;
		solve(node);

		return res;
	}

	private int solve(Node root) {
		if (root == null)
			return 0;

		int left = solve(root.left);
		int right = solve(root.right);

		int temp = Math.max(root.data, Math.max(left, right) + root.data);
		int ans = Math.max(temp, root.data + left + right);
		res = Math.max(res, ans);

		return temp;
	}
}
