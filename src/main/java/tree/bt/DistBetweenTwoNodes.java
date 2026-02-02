package tree.bt;

public class DistBetweenTwoNodes {

	public int findDist(Node root, int a, int b) {
		Node lca = lca(root, a, b);

		int x = distFromLca(lca, a, 0);
		int y = distFromLca(lca, b, 0);

		return (x + y);
	}

	private Node lca(Node root, int p, int q) {
		if (root == null)
			return null;
		if (root.data == p || root.data == q)
			return root;

		Node left = lca(root.left, p, q);
		Node right = lca(root.right, p, q);
		if (left != null && right != null)
			return root;
		
		return left != null ? left : right;
	}

	private int distFromLca(Node root, int val, int level) {
		if (root == null)
			return -1;
		if (root.data == val)
			return level;

		int left = distFromLca(root.left, val, level + 1);
		if (left == -1)
			return distFromLca(root.right, val, level + 1);

		return left;
	}
}
