package tree.bst;

public class DeletionInBST {

	// Recursion
	public TreeNode delete1(TreeNode root, int data) {
		if (root == null)
			return null;

		if (data < root.val)
			root.left = delete1(root.left, data);

		else if (data > root.val)
			root.right = delete1(root.right, data);

		else {
			if (root.left == null && root.right == null)
				return null;
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;

			root.val = minNode(root.right).val;
			root.right = delete1(root.right, root.val);
		}

		return root;
	}

	// Iteration
	public TreeNode delete2(TreeNode root, int data) {
		if (root == null)
			return null;

		if (root.val == data)
			return delete2Helper(root);

		TreeNode temp = root;
		while (temp != null) {
			if (data <= temp.val) {
				if (temp.left != null && temp.left.val == data) {
					temp.left = delete2Helper(temp.left);
					break;
				} else {
					temp = temp.left;
				}
			} else {
				if (temp.right != null && temp.right.val == data) {
					temp.right = delete2Helper(temp.right);
					break;
				} else {
					temp = temp.right;
				}
			}
		}

		return root;
	}

	private TreeNode delete2Helper(TreeNode root) {
		if (root.left == null && root.right == null)
			return null;
		if (root.left == null)
			return root.right;
		if (root.right == null)
			return root.left;
		
		TreeNode leftChild = root.left;
		TreeNode minNode = minNode(root.right);
		minNode.left = leftChild;
		return root.right;
	}

	private TreeNode minNode(TreeNode root) {
		if (root.left == null)
			return root;
		
		return minNode(root.left);
	}


	// Latest
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val == key) {
			return deleteNodeHelper(root);
		}

		TreeNode curr = root;
		while (curr != null ) {
			if (key <= curr.val) {
				if (curr.left != null && curr.left.val == key) {
					curr.left = deleteNodeHelper(curr.left);
					break;
				} else {
					curr = curr.left;
				}
			} else {
				if (curr.right != null && curr.right.val == key) {
					curr.right = deleteNodeHelper(curr.right);
					break;
				} else {
					curr = curr.right;
				}
			}
		}

		return root;
	}

	private TreeNode deleteNodeHelper(TreeNode root) {
		if (root.left == null) {
			return root.right;
		}
		if (root.right == null) {
			return root.left;
		}

		TreeNode rightChild = root.right;
		TreeNode lastRight = findLastRight(root.left);
		lastRight.right = rightChild;
		return root.left;
	}

	private TreeNode findLastRight(TreeNode node) {
		if (node.right == null) {
			return node;
		}
		return findLastRight(node.right);
	}
}
