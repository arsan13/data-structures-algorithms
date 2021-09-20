package tree.bst;

public class CeilOfBST {

	// Iteration
	public int ceil1(Node root, int key) {
		int ceil = -1;

		while (root != null) {
			if (root.data == key) {
				ceil = root.data;
				return ceil;
			}

			if (root.data < key) {
				root = root.right;
			} else {
				ceil = root.data;
				root = root.left;
			}
		}

		return ceil;
	}

	// Recursion
	public int ceil2(Node root, int key) {
		if (root == null)
			return -1;

		if (root.data == key)
			return root.data;

		if (root.data < key)
			return ceil2(root.right, key);

		int ceil = ceil2(root.left, key);
		return ceil >= key ? ceil : root.data;
	}
}
