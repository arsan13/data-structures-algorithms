package tree.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Bfs {

	public void levelOrder(Node root) {
		if (root == null)
			return;

		Deque<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + " ");
			if (temp.left != null)
				queue.addLast(temp.left);
			if (temp.right != null)
				queue.addLast(temp.right);
		}
	}

	public void reverseLevelOrder(Node root) {
		if (root == null)
			return;

		Deque<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node node = queue.removeFirst();
			if (node.right != null)
				queue.addLast(node.right);
			if (node.left != null)
				queue.addLast(node.left);
			stack.push(node);
		}

		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.print(node.data + " ");
		}
	}

	public List<List<Integer>> zigzagLevelOrder(Node root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<List<Integer>> res = new ArrayList<>();

		Deque<Node> queue = new LinkedList<>();
		queue.add(root);

		boolean leftToRight = true;
		while (!queue.isEmpty()) {
			int size = queue.size();

			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();

				if (leftToRight) {
					list.addLast(node.data);
				} else {
					list.addFirst(node.data);
				}

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			res.add(list);
			leftToRight = !leftToRight;
		}

		return res;
	}
}
