package tree.bt;

/* A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left 
 * subtree and right subtree. An empty tree is SumTree and the sum of an empty tree can be considered as 0. 
 * A leaf node is also considered as SumTree.
 */
public class IsSumTree {
	public boolean isSumTree(Node root) {
		if (root == null || (root.left == null && root.right == null))
			return true;

		int leftSum = sum(root.left);
		int rightSum = sum(root.right);
		if (root.data == leftSum + rightSum)
			return true;

		isSumTree(root.left);
		isSumTree(root.right);
		return false;
	}

	private int sum(Node root) {
		if (root == null)
			return 0;

		return (sum(root.left) + root.data + sum(root.right));
	}
}
