package tree.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfTree {

	/***********************************
	 * Method-1: Iteration | Level order
	 ***********************************/

	private class Pair1 {
		Node node;
		int dist;

		Pair1(Node node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	public ArrayList<Integer> bottomView1(Node root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Map<Integer, Node> map = new TreeMap<>();
		Queue<Pair1> queue = new LinkedList<>();

		queue.add(new Pair1(root, 0));
		while (!queue.isEmpty()) {
			Pair1 pair = queue.poll();
			Node node = pair.node;
			int dist = pair.dist;

			map.put(dist, node);

			if (node.left != null)
				queue.add(new Pair1(node.left, dist - 1));
			if (node.right != null)
				queue.add(new Pair1(node.right, dist + 1));
		}

		for (int dist : map.keySet())
			res.add(map.get(dist).data);

		return res;
	}

	/************************************
	 * Method-2: Recursion
	 ************************************/

	private class Pair2 {
		Node node;
		int level;

		Pair2(Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}

	public ArrayList<Integer> bottomView2(Node root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;

		Map<Integer, Pair2> map = new TreeMap<>();
		bottomViewRec(root, map, 0, 0);

		for (int dist : map.keySet())
			res.add(map.get(dist).node.data);

		return res;
	}

	private void bottomViewRec(Node root, Map<Integer, Pair2> map, int dist, int level) {

		if (root == null)
			return;

		if (!map.containsKey(dist) || map.get(dist).level <= level)
			map.put(dist, new Pair2(root, level));

		bottomViewRec(root.left, map, dist - 1, level + 1);
		bottomViewRec(root.right, map, dist + 1, level + 1);
	}
}
