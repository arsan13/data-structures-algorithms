package tree.bst;

public class LowestCommonAncestor {
	
	// O(N) Auxiliary Space
	public TreeNode lcaRecursion(TreeNode root, TreeNode p, TreeNode q) {
		int parentVal = root.val;
		int pVal = p.val;
		int qVal = q.val;

		if (pVal > parentVal && qVal > parentVal)
			return lcaRecursion(root.right, p, q);
		else if (pVal < parentVal && qVal < parentVal)
			return lcaRecursion(root.left, p, q);
		else
			return root;
	}

	// O(1) Space
	public TreeNode lcaIteration(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode node = root;
		int pVal = p.val;
		int qVal = q.val;

		while (node != null) {
			int parentVal = node.val;

			if (pVal > parentVal && qVal > parentVal)
				node = node.right;
			else if (pVal < parentVal && qVal < parentVal)
				node = node.left;
			else
				return node;
		}

		return null;
	}
}
