package tree.bt;

import java.util.HashMap;
import java.util.Map;

//Given a binary tree, find out whether it contains a duplicate sub-tree of size two or more, or not.
public class CheckDuplicateSubtree {
	Map<String, Integer> map = new HashMap<>();

	public boolean dupSub(Node root) {
		fillPattern(root);
		
		for (String key : map.keySet()) {
			if (map.get(key) > 1)
				return true;
		}

		return false;
	}

	private String fillPattern(Node root) {

		if (root == null)
			return "$";

		String str = "";
		if (root.left == null && root.right == null) { // leaf
			str += root.data;
			return str;
		}

		str += root.data;
		str += fillPattern(root.left);
		str += fillPattern(root.right);

		map.put(str, map.getOrDefault(str, 0) + 1);
		return str;
	}
}
