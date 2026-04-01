package tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrder {

	public static void main(String[] args) {
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println(new VerticalOrder().verticalTraversal(root));
	}

    public List<List<Integer>> verticalTraversal(Node root) {
        if (root == null) {
			return new ArrayList<>();
		}

        // column -> row -> minHeap
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> columnMap = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple curr = queue.poll();
			int col = curr.col;
			int row = curr.row;

			if (!columnMap.containsKey(col)) {
				columnMap.put(col, new TreeMap<>());
			}
			if (!columnMap.get(col).containsKey(row)) {
				columnMap.get(col).put(row, new PriorityQueue<>());
			}
			columnMap.get(col).get(row).offer(curr.node.data);

//			columnMap
//					.computeIfAbsent(col, c -> new TreeMap<>())
//					.computeIfAbsent(row, r -> new PriorityQueue<>())
//					.offer(curr.node.data);

            if (curr.node.left != null) {
                queue.offer(new Tuple(curr.node.left, col - 1, row + 1));
            }

            if (curr.node.right != null) {
                queue.offer(new Tuple(curr.node.right, col + 1, row + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rowMap : columnMap.values()) {
            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> minHeap : rowMap.values()) {
                while (!minHeap.isEmpty()) {
                    column.add(minHeap.poll());
                }
            }

            result.add(column);
        }

        return result;
    }

    private static class Tuple {
        Node node;
        int col; // horizontal distance
        int row; // level (depth)

        Tuple(Node node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
}
