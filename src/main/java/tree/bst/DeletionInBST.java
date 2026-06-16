package tree.bst;

public class DeletionInBST {

	// Recursion
	public Node delete1(Node root, int data) {
		if (root == null)
			return null;

		if (data < root.data)
			root.left = delete1(root.left, data);

		else if (data > root.data)
			root.right = delete1(root.right, data);

		else {
			if (root.left == null && root.right == null)
				return null;
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;

			root.data = minNode(root.right).data;
			root.right = delete1(root.right, root.data);
		}

		return root;
	}

	// Iteration
	public Node delete2(Node root, int data) {
		if (root == null)
			return null;

		if (root.data == data) 
			return delete2Helper(root);

		Node temp = root;
		while (temp != null) {
			if (data <= temp.data) {
				if (temp.left != null && temp.left.data == data) {
					temp.left = delete2Helper(temp.left);
					break;
				} else {
					temp = temp.left;
				}
			} else {
				if (temp.right != null && temp.right.data == data) {
					temp.right = delete2Helper(temp.right);
					break;
				} else {
					temp = temp.right;
				}
			}
		}

		return root;
	}

	private Node delete2Helper(Node root) {
		if (root.left == null && root.right == null)
			return null;
		if (root.left == null)
			return root.right;
		if (root.right == null)
			return root.left;
		
		Node leftChild = root.left;
		Node minNode = minNode(root.right);
		minNode.left = leftChild;
		return root.right;
	}

	private Node minNode(Node root) {
		if (root.left == null)
			return root;
		
		return minNode(root.left);
	}


	// Latest
	public Node deleteNode(Node root, int key) {
		if (root == null) {
			return null;
		}
		if (root.data == key) {
			return deleteNodeHelper(root);
		}

		Node curr = root;
		while (curr != null ) {
			if (key <= curr.data) {
				if (curr.left != null && curr.left.data == key) {
					curr.left = deleteNodeHelper(curr.left);
					break;
				} else {
					curr = curr.left;
				}
			} else {
				if (curr.right != null && curr.right.data == key) {
					curr.right = deleteNodeHelper(curr.right);
					break;
				} else {
					curr = curr.right;
				}
			}
		}

		return root;
	}

	private Node deleteNodeHelper(Node root) {
		if (root.left == null) {
			return root.right;
		}
		if (root.right == null) {
			return root.left;
		}

		Node rightChild = root.right;
		Node lastRight = findLastRight(root.left);
		lastRight.right = rightChild;
		return root.left;
	}

	private Node findLastRight(Node node) {
		if (node.right == null) {
			return node;
		}
		return findLastRight(node.right);
	}
}
