package tree.bt.group1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/* Given the root of a binary tree, the value of a target node or target node itself, and an integer k, 
 * return an array/list of the values of all nodes that have a distance k from the target node.*/
public class PrintNodesAtDistanceK {

	public List<Integer> distanceK(Node root, Node target, int k) {
		Map<Node, Node> parent = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		Set<Node> visited = new HashSet<>();
		
		queue.add(target);
		visited.add(target);
		parent = getParents(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			if(k == 0)
				break;
			
			k--;
			
			for(int i = 0; i < size; i++) {
				Node node = queue.poll();
				
				if(node.left != null && !visited.contains(node.left)) {
					queue.add(node.left);
					visited.add(node.left);
				}
				
				if(node.right != null && !visited.contains(node.right)) {
					queue.add(node.right);
					visited.add(node.right);
				}
				
				Node p = parent.get(node);
				if(p != null && !visited.contains(p)) {
					queue.add(p);
					visited.add(p);
				}
			}
		}
		
		List<Integer> list = new ArrayList<>();
		while(!queue.isEmpty()) {
			list.add(queue.poll().data);
		}
		
		return list;
	}

	private Map<Node, Node> getParents(Node root) {
		Map<Node, Node> parent = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
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
