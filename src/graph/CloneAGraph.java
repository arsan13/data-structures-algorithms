package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneAGraph {
	
	static class Node {
		int val;
		List<Node> neighbours;

		Node(int val) {
			this.val = val;
		}

		public Node(int val, List<Node> neighbours) {
			this.val = val;
			this.neighbours = neighbours;
		}
	}
	
	public static Node cloneGraphUsingBFS(Node node) {
	    
        if(node == null)
            return null;
        
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        Node root = new Node(node.val, new ArrayList<>());
        map.put(node, root);
        queue.add(node);
        
        while(!queue.isEmpty()) {
            Node u = queue.poll();
            
            for(Node v : u.neighbours) {
                if(!map.containsKey(v)) {
                    queue.add(v);
                    map.put(v, new Node(v.val, new ArrayList<>()));
                }
                map.get(u).neighbours.add(map.get(v));
            }
        }
        
        return root;
    }
	
	public static Node cloneGraphUsingDFS(Node node) {
	     
        if(node == null)
            return null;
        
        Map<Integer, Node> map = new HashMap<>();
        Node copy = new Node(node.val);
        
        dfs(node, copy, map);
        
        return copy;
    }
    
    private static void dfs(Node node, Node copy, Map<Integer, Node> map) {
        map.put(copy.val, copy);
        
        for(Node v : node.neighbours) {
            if(!map.containsKey(v.val)) {
                Node newNode = new Node(v.val);
                copy.neighbours.add(newNode);
                dfs(v, newNode, map);
            }
            else {
                copy.neighbours.add(map.get(v.val));
            }
        }
    }
	
	public static void main(String[] args) {
		
//		1--2
//      |  |
//      4--3
		
		List<Node> list = new ArrayList<>();
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		list.add(node2);
		list.add(node4);
		node1.neighbours = list;
		
		list.clear();
		
		list.add(node1);
		list.add(node3);
		node2.neighbours = list;
		
		list.clear();
		
		list.add(node2);
		list.add(node4);
		node3.neighbours = list;
		
		list.clear();
		
		list.add(node1);
		list.add(node3);
		node4.neighbours = list;
		
//		Node copy1 = cloneGraphUsingDFS(node1);
		Node copy2 = cloneGraphUsingBFS(node1);
		
		System.out.println(copy2.val);
	}
}
