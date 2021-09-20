package tree.bt.height;

//Time O(n * n) 
class BalancedBinaryTree1 {

	public boolean isBalanced(Node root) {
		if (root == null)
			return true;

		int lh = height(root.left);
		int rh = height(root.right);

//		if (Math.abs(lh - rh) > 1)
//			return false;
//
//		boolean leftCheck = isBalanced(root.left);
//		boolean rightCheck = isBalanced(root.right);
//
//		if (!leftCheck || !rightCheck)
//			return false;
//
//		return true;

		if ((Math.abs(lh - rh) <= 1) && isBalanced(root.left) && isBalanced(root.right))
			return true;

		return false;

	}

	private int height(Node root) {
		if (root == null)
			return 0;

		int lh = height(root.left);
		int rh = height(root.right);

		return 1 + Math.max(lh, rh);
	}
}

//Time O(n) 
class BalancedBinaryTree2 {

	public boolean isBalanced(Node root) {
		if (height(root) == -1)
			return false;
		return true;
	}

	private int height(Node root) {
		if (root == null)
			return 0;

		int lh = height(root.left);
		int rh = height(root.right);

		if (lh == -1 || rh == -1)
			return -1;
		if (Math.abs(lh - rh) > 1)
			return -1;

		return 1 + Math.max(lh, rh);
	}
}
