package tree.bst;

public class InsertionInBST {

	// Recursion
	private TreeNode insert1(TreeNode root, int data) {
		if (root == null) {
            return new TreeNode(data);
		}

		if (data <= root.val) {
			root.left = insert1(root.left, data);
		} else {
			root.right = insert1(root.right, data);
		}

		return root;
	}

	// Iteration
	private TreeNode insert2(TreeNode root, int data) {
		if (root == null) {
            return new TreeNode(data);
		}

		TreeNode temp = root;
		while (temp != null) {
			if (data <= temp.val) {
				if (temp.left != null) {
					temp = temp.left;
				} else {
					temp.left = new TreeNode(data);
					break;
				}
			} else {
				if (temp.right != null) {
					temp = temp.right;
				} else {
					temp.right = new TreeNode(data);
					break;
				}
			}
		}

		return root;
	}

	// Iteration
	private TreeNode insert3(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}

		TreeNode curr = root;
		TreeNode prev = null;

		while (curr != null) {
			prev = curr;
			curr = curr.val > val ? curr.left : curr.right;
		}

		if (prev.val > val) {
			prev.left = new TreeNode(val);
		} else {
			prev.right = new TreeNode(val);
		}

		return root;
	}
}
