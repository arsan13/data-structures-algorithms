package tree.traversal;

import java.util.Stack;

public class Dfs {
	
	public void preOrder(Node root) {
		if (root == null)
			return;

		// Recursion
//		System.out.print(root.data + " ");
//		preOrder(root.left);
//		preOrder(root.right);

		// Iteration
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.data + " ");
			if (root.right != null)
				stack.push(root.right);
			if (root.left != null)
				stack.push(root.left);
		}
	}

	public void inOrder(Node root) {
		if (root == null)
			return;

		// Recursion
//		inOrder(root.left);
//		System.out.print(root.data + " ");
//		inOrder(root.right);

		// Iteration
		Stack<Node> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				System.out.print(root.data + " ");
				root = root.right;
			}
		}
	}

	public void postOrder(Node root) {
		if (root == null)
			return;

		// Recursive
//		postOrder(root.left);
//		postOrder(root.right);
//		System.out.print(root.data + " ");

		// Iteration : Two Stacks
//		Stack<Node> stack1 = new Stack<>();
//		Stack<Node> stack2 = new Stack<>();
//		stack1.push(root);
//		
//		while(!stack1.isEmpty()) {
//			root = stack1.pop();
//			stack2.push(root);
//			if(root.left != null)
//				stack1.push(root.left);
//			if(root.right != null)
//				stack2.push(root.right);
//		}
//		
//		while(!stack2.isEmpty()) {
//			root = stack2.pop();
//			System.out.print(root.data + " ");
//		}

		// Iteration : Single Stack
		Stack<Node> stack = new Stack<>();
		Node current = root;
		Node prev = null;

		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.peek();
				if (current.right == null || current.right == prev) {
					System.out.print(current.data + " ");
					stack.pop();
					prev = current;
					current = null;
				} else
					current = current.right;
			}
		}
	}
}
