package tree.bst;

public class CeilOfBST {

	// Iteration
	public int ceil1(TreeNode root, int key) {
		int ceil = -1;

		while (root != null) {
			if (root.val == key) {
				ceil = root.val;
				return ceil;
			}

			if (root.val < key) {
				root = root.right;
			} else {
				ceil = root.val;
				root = root.left;
			}
		}

		return ceil;
	}

	// Recursion
	public int ceil2(TreeNode root, int key) {
		if (root == null)
			return -1;

		if (root.val == key)
			return root.val;

		if (root.val < key)
			return ceil2(root.right, key);

		int ceil = ceil2(root.left, key);
		return ceil >= key ? ceil : root.val;
	}
}
