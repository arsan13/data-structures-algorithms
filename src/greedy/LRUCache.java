package greedy;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	static class Node {
		int key, value;
		Node next, prev;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	int capacity;
	Node head, tail;
	Map<Integer, Node> map;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new Node(0, 0); //pointer
		tail = new Node(0, 0);
		head.next = tail;
		head.prev = null;
		tail.prev = head;
		tail.next = null;
	}
	
	public int get(int key) {
		int res = -1;
		if(map.containsKey(key)) {
			Node node = map.get(key);
			delete(node);
			add(node);
			res = node.value;
		}
		return res;
	}
	
	public void put(int key, int value) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			delete(node);
			add(node);
		}
		else {
			Node newNode = new Node(key, value);
			
			if(map.size() == capacity) {
				Node last = tail.prev;
				map.remove(last.key);
				delete(last);
				add(newNode);
				map.put(key, newNode);
			}
			else {
				add(newNode);
				map.put(key, newNode);
			}
		}	
	}
	
	private void add(Node node) {
		node.next = head.next;
		node.next.prev = node;
		node.prev = head;
		head.next = node;
	}
	
	private void delete(Node node) {		
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	public static void main(String[] args) {	
		
		int capacity = 3;
		LRUCache lru = new LRUCache(capacity);
		
		lru.put(1, 10);
		lru.put(2, 20);
		lru.put(3, 30);
		System.out.println(lru.get(2));
		System.out.println(lru.get(5));
		lru.put(4, 30);
	}
}
