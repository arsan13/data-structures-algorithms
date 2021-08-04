package linkedList;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

	// O(1) Space
	private static boolean isCycle1(Node head) {
		if(head == null) {
			return false;
		}
		
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if(slow == fast) {
				return true;
			}
		}
		
		return false;
	}

	private static boolean isCycle2(Node head) {
		if(head == null) {
			return false;
		}
		
		Node temp = head;
		Set<Node> set = new HashSet<>();
		while(temp != null) {
			if(set.contains(temp)) {
				return true;
			}
			set.add(temp);
			temp = temp.next;
		}
		
		return false;
	}
	
	public static void main(String[] args) {

		Node head;
		Node tail;
		
		head = tail = new Node(10);
		Node node = new Node(20);
		tail.next = node;			tail = tail.next;
		tail.next = new Node(30);	tail = tail.next;
		tail.next = new Node(40);	tail = tail.next;
		tail.next = new Node(50);	tail = tail.next;
		tail.next = node;			tail = tail.next;
				
//		10 - 20 - 30 - 40
//				\	  /
//				  50
		System.out.println(isCycle1(head));
		System.out.println(isCycle2(head));
	}
}
