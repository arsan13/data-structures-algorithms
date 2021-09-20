package tree.bst;

public class InsertionInBST {

	// Recursion
	private Node insert1(Node root, int data) {
		if (root == null) {
			Node newNode = new Node(data);
			return newNode;
		}

		if (data <= root.data) {
			root.left = insert1(root.left, data);
		} else {
			root.right = insert1(root.right, data);
		}

		return root;
	}

	// Iteration
	private Node insert2(Node root, int data) {
		if (root == null) {
			Node newNode = new Node(data);
			return newNode;
		}

		Node temp = root;
		while (temp != null) {
			if (data <= temp.data) {
				if (temp.left != null) {
					temp = temp.left;
				} else {
					temp.left = new Node(data);
					break;
				}
			} else {
				if (temp.right != null) {
					temp = temp.right;
				} else {
					temp.right = new Node(data);
					break;
				}
			}
		}

		return root;
	}
}
