package tree.bt;

import java.util.HashMap;
import java.util.Map;

//Maximum sum of nodes in Binary tree such that no two are adjacent.
public class MaxSumNoAdjacent {
	Map<Node, Integer> DPmap = new HashMap<>();

	public int sum(Node root) {
		if (root == null)
			return 0;

		if (DPmap.containsKey(root))
			return DPmap.get(root);

		int includeRoot = root.data;
		if (root.left != null)
			includeRoot += sum(root.left.left);
		if (root.right != null)
			includeRoot += sum(root.right.right);

		int excludeRoot = sum(root.left) + sum(root.right);

		int res = Math.max(includeRoot, excludeRoot);

		DPmap.put(root, res);
		return DPmap.get(root);
	}
}
