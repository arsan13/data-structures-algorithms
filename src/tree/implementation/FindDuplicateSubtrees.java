package tree.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
	List<Node> list;
	Map<String, Integer> map;

	public List<Node> printAllDups(Node root) {
		list = new ArrayList<>();
		map = new HashMap<>();

		duplicate(root);
		return list;
	}

	private String duplicate(Node root) {

		if (root == null)
			return "$";

		String l = duplicate(root.left);
		String r = duplicate(root.right);
		String str = Integer.toString(root.data) + "->" + l + "->" + r;

		map.put(str, map.getOrDefault(str, 0) + 1);
		if (map.get(str) == 2) {
			list.add(root);
		}
		
		return str;
	}
}
