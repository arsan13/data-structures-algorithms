package tree.bt.height;

// BRUTE FORCE | O(n * n) time
class DiameterOfBinaryTree1 {

//	private int res;
//	public int diameter(Node root) {
//		res = 0;
//		diameterUtil(root);
//
//		return res;
//	}
//
//	private void diameterUtil(Node root) {
//		if(root == null)
//			return;
//		
//		int lh = height(root.left);
//		int rh = height(root.right);
//		
//		res = Math.max(res, lh + rh);
//		
//		diameterUtil(root.left);
//		diameterUtil(root.right);
//	}

	public int diameter(Node root) {
		if (root == null)
			return 0;

		int lh = height(root.left);
		int rh = height(root.right);

		int ld = diameter(root.left);
		int rd = diameter(root.right);

		return Math.max(lh + rh, Math.max(ld, rd)); // We have added lh + rh and not lh + rh + 1 because in some
													// cases(leetcode) number of paths should be considered, not nodes.
	}

	private int height(Node root) {
		if (root == null)
			return 0;

		return 1 + Math.max(height(root.left), height(root.right));
	}

}

// OPTIMAL | O(n) time	
class DiameterOfBinaryTree2 {

	private int res;

	public int diameter(Node root) {
		res = 0;
		height(root);
		return res;
	}

	private int height(Node root) {
		if (root == null)
			return 0;

		int left = height(root.left);
		int right = height(root.right);

		res = Math.max(res, left + right); // We have added lh + rh and not lh + rh + 1 because in some
										   // cases(leetcode) number of paths should be considered, not nodes.
		return 1 + Math.max(left, right);
	}

}
