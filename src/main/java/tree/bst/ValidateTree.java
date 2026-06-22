package tree.bst;

// Check if a binary tree is a BST. 
public class ValidateTree {

	public boolean isBST(TreeNode root) {
		return isBST(root, null, null);
	}

	private boolean isBST(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;

		if ((min != null && root.val <= min) || (max != null && root.val >= max))
			return false;

		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}

		if (root.val <= min || root.val >= max) {
			return false;
		}

		return isValidBST(root.left, min, root.val) &&
				isValidBST(root.right, root.val, max);
	}
}
