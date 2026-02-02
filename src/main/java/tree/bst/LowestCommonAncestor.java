package tree.bst;

public class LowestCommonAncestor {
	
	// O(N) Auxiliary Space
	public Node lcaRecursion(Node root, Node p, Node q) {
		int parentVal = root.data;
		int pVal = p.data;
		int qVal = q.data;

		if (pVal > parentVal && qVal > parentVal)
			return lcaRecursion(root.right, p, q);
		else if (pVal < parentVal && qVal < parentVal)
			return lcaRecursion(root.left, p, q);
		else
			return root;
	}

	// O(1) Space
	public Node lcaIteration(Node root, Node p, Node q) {
		Node node = root;
		int pVal = p.data;
		int qVal = q.data;

		while (node != null) {
			int parentVal = node.data;

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
