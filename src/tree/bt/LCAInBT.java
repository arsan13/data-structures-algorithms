package tree.bt;

//Given a binary tree and two nodes say p and 1, write a function to find the least common ancestor.
public class LCAInBT {

	public Node lowestCommonAncestor(Node root, Node p, Node q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;

		Node left = lowestCommonAncestor(root.left, p, q);
		Node right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}
}
