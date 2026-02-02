package tree.bst;

public class FloorOfBST {

	// Iteration
	public int floor1(Node root, int key) {
		int floor = Integer.MAX_VALUE;

		while (root != null) {
			if (root.data == key) {
				floor = root.data;
				return floor;
			}

			if (root.data < key) {
				floor = root.data;
				root = root.right;
			} else {
				root = root.left;
			}
		}

		return floor;
	}

	// Recursion
	public int floor2(Node root, int key) {
		if (root == null)
			return Integer.MAX_VALUE;

		if (root.data == key)
			return root.data;

		if (root.data > key)
			return floor2(root.left, key);

		int floor = floor2(root.right, key);
		return floor <= key ? floor : root.data;
	}

}
