package dp.tree;

public class DiameterOfBinaryTree {

	private int res;

	public int diameter(Node root) {
		res = 0;
		solve(root);

		return res;
	}

	private int solve(Node root) {
		if (root == null)
			return 0;

		int left = solve(root.left);
		int right = solve(root.right);

		int temp = 1 + Math.max(left, right);
		int ans = Math.max(temp, 1 + left + right);
		res = Math.max(res, ans);

		return temp;
	}
}
