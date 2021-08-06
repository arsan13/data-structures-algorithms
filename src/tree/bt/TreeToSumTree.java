package tree.bt;

public class TreeToSumTree {
	public void toSumTree(Node root) {
		solve(root);
	}

	private int solve(Node root) {

		if (root == null) // Leaf nodes will have value 0
			return 0;

		int leftVal = solve(root.left);
		int rightVal = solve(root.right);
		int rootVal = root.data;
		
		root.data = leftVal + rightVal;
		return leftVal + rightVal + rootVal;
	}
}
