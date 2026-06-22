package tree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralOrder {

	public void spiralOrder1(Node root) {
		if (root == null)
			return;

		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);

		while (!stack1.isEmpty() || !stack2.isEmpty()) {

			while (!stack1.isEmpty()) {
				root = stack1.pop();
				System.out.print(root.data + " ");

				if (root.left != null)
					stack2.push(root.left);
				if (root.right != null)
					stack2.push(root.right);
			}

			while (!stack2.isEmpty()) {
				root = stack2.pop();
				System.out.print(root.data + " ");

				if (root.right != null)
					stack1.push(root.right);
				if (root.left != null)
					stack1.push(root.left);
			}
		}
	}

	public void spiralOrder2(Node root) {
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		boolean ltr = false;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.println(node.data);

			if (ltr == true) {
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			} else {
				if (node.right != null)
					queue.add(node.right);
				if (node.left != null)
					queue.add(node.left);
			}

			ltr = !ltr;
		}

	}
}
