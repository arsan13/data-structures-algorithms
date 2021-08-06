package tree.bt;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class TopViewOfTree {

	public ArrayList<Integer> topView(Node root) {
		ArrayList<Integer> res = new ArrayList<>();
		Map<Integer, Pair> map = new TreeMap<>();
		topViewRec(root, map, 0, 0);

		for (int dist : map.keySet())
			res.add(map.get(dist).node.data);

		return res;
	}

	private void topViewRec(Node root, Map<Integer, Pair> map, int dist, int level) {

		if (root == null)
			return;

		if (!map.containsKey(dist) || map.get(dist).level > level)
			map.put(dist, new Pair(root, level));

		topViewRec(root.left, map, dist - 1, level + 1);
		topViewRec(root.right, map, dist + 1, level + 1);
	}
	
	private class Pair {
		Node node;
		int level;

		Pair(Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}
}
