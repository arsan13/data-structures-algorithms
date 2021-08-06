package tree.bt;

//Convert given tree to doubly linked list.
public class TreeToDLL {
	Node head = null;
	Node prev = null;

	public Node treeToDLL(Node root) {
		inorder(root);
		return head;
	}

	private void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);

		if (prev == null) {
			head = root;
		} else {
			prev.right = root;
			root.left = prev;
		}
		prev = root; // prev = prev.next;

		inorder(root.right);
	}
}
