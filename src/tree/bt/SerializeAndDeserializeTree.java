package tree.bt;

import java.util.LinkedList;
import java.util.Queue;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or 
another computer environment.
Ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
*/
public class SerializeAndDeserializeTree {

	public String serialize(Node root) {
		if (root == null)
			return "";
		
		Queue<Node> q = new LinkedList<>();
		StringBuilder res = new StringBuilder();
		
		q.add(root);
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node == null) {
				res.append("n ");
				continue;
			}
			res.append(node.data + " ");
			
			q.add(node.left);
			q.add(node.right);
		}
		return res.toString();
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		if (data == "")
			return null;
		
		Queue<Node> q = new LinkedList<>();
		String[] values = data.split(" ");
		Node root = new Node(Integer.parseInt(values[0]));
		q.add(root);
		
		for (int i = 1; i < values.length; i++) {
			Node parent = q.poll();
			
			if (!values[i].equals("n")) {
				Node left = new Node(Integer.parseInt(values[i]));
				parent.left = left;
				q.add(left);
			}
			
			if (!values[++i].equals("n")) {
				Node right = new Node(Integer.parseInt(values[i]));
				parent.right = right;
				q.add(right);
			}
		}
		
		return root;
	}
}
