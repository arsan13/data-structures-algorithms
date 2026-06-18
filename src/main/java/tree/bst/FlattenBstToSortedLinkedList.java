package tree.bst;

/* Given a BST, flatten it into linked list in-place. Usage of auxiliary data structure is not allowed. 
 * After flattening, left of each node should point to NULL and right should contain next node in level order.
 */
public class FlattenBstToSortedLinkedList {

	public TreeNode flatten(TreeNode root) {
		TreeNode dummy = new TreeNode(-1);
		TreeNode prev = dummy;

		inOrder(root, prev);

		prev.left = null;
		prev.right = null;
		return dummy.right;
	}

	private void inOrder(TreeNode curr, TreeNode prev) {
		if (curr == null)
			return;

		inOrder(curr.left, prev);

		prev.left = null;
		prev.right = curr;
		prev = curr;

		inOrder(curr.right, prev);
	}
}
