package tree.bt.group;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
* Given a binary tree and a leaf/target node from this tree. It is known that in 1s all nodes connected to a given 
* node (left child, right child and parent) get burned in 1 second. Then all the nodes which are connected 
* through one intermediate get burned in 2 seconds, and so on. 
* The task is to find the minimum time required to burn the complete binary tree.
*/
public class BurningOfTree {

	public int minTime(Node root, Node target) {
		Map<Node, Node> parent = getParents(root);	
		Queue<Node> queue = new LinkedList<>();
		Set<Node> visited = new HashSet<>();
		
		queue.add(target);
		visited.add(target);
		
		int time = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			boolean flag = false;
			
			for(int i = 0; i < size; i++) {
				Node node = queue.poll();
				
				if(node.left != null && !visited.contains(node.left)) {
					flag = true;
					queue.add(node.left);
					visited.add(node.left);
				}
				
				if(node.right != null && !visited.contains(node.right)) {
					flag = true;
					queue.add(node.right);
					visited.add(node.right);
				}
				
				Node p = parent.get(node);
				if(p != null && !visited.contains(p)) {
					flag = true;
					queue.add(p);
					visited.add(p);
				}
			}
			
			if(flag == true) {
				time++;
			}
		}
		
		return time;
	}

	private Map<Node, Node> getParents(Node root) {
		Map<Node, Node> parent = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		parent.put(root, null);
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.left != null) {
				parent.put(node.left, node);
				queue.add(node.left);
			}
			
			if(node.right != null) {
				parent.put(node.right, node);
				queue.add(node.right);
			}
		}
		
		return parent;
	}
}
