package tree.traversal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Bfs {

	public void levelOrder(Node root) {
		if (root == null)
			return;

		Deque<Node> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
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

		while (queue.size() > 0) {
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
}
