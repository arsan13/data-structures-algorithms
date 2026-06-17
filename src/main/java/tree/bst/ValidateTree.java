package tree.bst;

// Check if a binary tree is a BST. 
public class ValidateTree {

	public boolean isBST(Node root) {
		return isBST(root, null, null);
	}

	private boolean isBST(Node root, Integer min, Integer max) {
		if (root == null)
			return true;

		if ((min != null && root.data <= min) || (max != null && root.data >= max))
			return false;

		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
	}

	public boolean isValidBST(Node root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(Node root, long min, long max) {
		if (root == null) {
			return true;
		}

		if (root.data <= min || root.data >= max) {
			return false;
		}

		return isValidBST(root.left, min, root.data) &&
				isValidBST(root.right, root.data, max);
	}
}
