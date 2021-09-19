package tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrder {

	private class Tuple {
		Node node;
		int row;
		int col;

		public Tuple(Node _node, int _row, int _col) {
			node = _node;
			row = _row;
			col = _col;
		}
	}

	public List<List<Integer>> verticalTraversal(Node root) {
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(root, 0, 0));

		while (!queue.isEmpty()) {
			Tuple tuple = queue.poll();
			Node node = tuple.node;
			int x = tuple.row;
			int y = tuple.col;

			if (!map.containsKey(x))
				map.put(x, new TreeMap<>());
			if (!map.get(x).containsKey(y))
				map.get(x).put(y, new PriorityQueue<>());

			map.get(x).get(y).add(node.data);

			if (node.left != null)
				queue.add(new Tuple(node.left, x - 1, y + 1));
			if (node.right != null)
				queue.add(new Tuple(node.right, x + 1, y + 1));
		}

		List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> sMap : map.values()) {
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : sMap.values()) {
                while(!nodes.isEmpty()) {
                    list.add(nodes.poll());
                }
            }
            res.add(list);
        }
        
        return res;
	}
}
