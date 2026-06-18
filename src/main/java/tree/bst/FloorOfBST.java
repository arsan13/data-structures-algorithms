package tree.bst;

public class FloorOfBST {

	// Iteration
	public int floor1(TreeNode root, int key) {
		int floor = Integer.MAX_VALUE;

		while (root != null) {
			if (root.val == key) {
				floor = root.val;
				return floor;
			}

			if (root.val < key) {
				floor = root.val;
				root = root.right;
			} else {
				root = root.left;
			}
		}

		return floor;
	}

	// Recursion
	public int floor2(TreeNode root, int key) {
		if (root == null)
			return Integer.MAX_VALUE;

		if (root.val == key)
			return root.val;

		if (root.val > key)
			return floor2(root.left, key);

		int floor = floor2(root.right, key);
		return floor <= key ? floor : root.val;
	}

}
