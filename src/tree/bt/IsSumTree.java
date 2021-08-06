package tree.bt;

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
