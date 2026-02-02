package tree.bt;

/* Given a binary tree, flatten it into linked list in-place. Usage of auxiliary data structure is not allowed. 
 * After flattening, left of each node should point to NULL and right should contain next node in level order.
 */
public class FlattenTreeToLinkedList {

	Node prev = null;

	public void flatten(Node root) {
		if (root == null)
			return;

		flatten(root.right);
		flatten(root.left);

		root.right = prev;
		root.left = null;
		prev = root;
	}
}
