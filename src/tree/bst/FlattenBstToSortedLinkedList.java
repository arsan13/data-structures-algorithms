package tree.bst;

/* Given a BST, flatten it into linked list in-place. Usage of auxiliary data structure is not allowed. 
 * After flattening, left of each node should point to NULL and right should contain next node in level order.
 */
public class FlattenBstToSortedLinkedList {

	public Node flatten(Node root) {
		Node dummy = new Node(-1);
		Node prev = dummy;

		inOrder(root, prev);

		prev.left = null;
		prev.right = null;
		return dummy.right;
	}

	private void inOrder(Node curr, Node prev) {
		if (curr == null)
			return;

		inOrder(curr.left, prev);

		prev.left = null;
		prev.right = curr;
		prev = curr;

		inOrder(curr.right, prev);
	}
}
