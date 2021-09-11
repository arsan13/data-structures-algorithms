package linkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveCycle {

	// O(n) time | O(n) Space
	private static void removeCycle2(Node head) {
		Set<Node> set = new HashSet<>();
		Node temp = head;
		Node prev = null;

		while (temp != null) {
			if (set.contains(temp)) {
				prev.next = null;
				break;
			}

			set.add(temp);
			prev = temp;
			temp = temp.next;
		}

	}

	// O(n) time | O(1) Space
	private static void removeCycle1(Node head) {
		Node meet = getMeetPoint(head);
		Node start = head;
		
		// No cycle
		if (meet == null)
			return;
		
		while (start != meet) {
			start = start.next;
			meet = meet.next;
		}

        // Get pointer to the last node
		while (meet.next != start) 
			meet = meet.next;

		meet.next = null;
	}

	// Detect Cycle
	private static Node getMeetPoint(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (slow == fast)
				return slow;
		}

		return null;
	}

	public static void main(String[] args) {

		Node head;
		Node tail;

		head = tail = new Node(10);
		Node node = new Node(20);
		tail.next = node;
		tail = tail.next;
		tail.next = new Node(30);
		tail = tail.next;
		tail.next = new Node(40);
		tail = tail.next;
		tail.next = new Node(50);
		tail = tail.next;
		tail.next = node;
		tail = tail.next;

//		10 - 20 - 30 - 40
//				\	  /
//				  50

//		removeCycle2(head);
		removeCycle1(head);
	}

}
