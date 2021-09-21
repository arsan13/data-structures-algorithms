package tree.bt;

import java.util.LinkedList;
import java.util.Queue;

// Given a binary tree, check whether it is a mirror of itself.
// 1. The left child of left subtree = right child of right subtree. 
// 2. The right child of left subtree = left child of right subtree. 
public class SymmetricTree {

	// Recursion
	public boolean isSymmetric1(Node root) {
		return isMirror(root, root);
	}

	private boolean isMirror(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;

		if (node1 != null && node2 != null && node1.data == node2.data)
			return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);

		return false;
	}
	
	// Iteration
	public boolean isSymmetric2(Node root) {
		if(root == null)
			return true;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);
		
		while(!queue.isEmpty()) {
			Node left = queue.poll();
			Node right = queue.poll();
			
			if(left == null && right == null)  // both are null
				continue;
			if(left == null || right == null)  // any one node is null
				return false;
			if(left.data != right.data)
				return false;
			
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		
		return true;
	}
}
