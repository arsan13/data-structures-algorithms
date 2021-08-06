package tree.bt;

import java.util.LinkedList;
import java.util.Queue;

public class KthAncestor {
	
	//BFS
	public int kthAncestor(Node root, int node, int n, int k) {
		int parent[] = new int[n + 1];
		getParents(root, parent);
		
		while(node != -1) {
			node = parent[node];
			k--;
			
			if(k == 0)
				break;
		}
		
		return node;
	}

	private void getParents(Node root, int[] parent) {
		Queue<Node> queue = new LinkedList<>();
		parent[root.data] = -1;
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			
			if(temp.left != null) {
				parent[temp.left.data] = temp.data;
				queue.add(temp.left);
			}
			if(temp.right != null) {
				parent[temp.right.data] = temp.data;
				queue.add(temp.right);
			}
		}
		
	}
}
