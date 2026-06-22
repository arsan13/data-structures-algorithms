package linkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	private static Node removeDuplicatesSortedList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node temp = head;
		while(temp.next != null) {
			if(temp.data == temp.next.data) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		
		return head;
	}
	
	private static Node removeDuplicatesUnsortedList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node curr = head;
		Node prev = null;
		Set<Integer> set = new HashSet<>();
		
		while(curr != null) {
			if(set.contains(curr.data)) {
				prev.next = curr.next;
			} else {
				set.add(curr.data);
				prev = curr;
			}
			
			curr = curr.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {

		Node head;
		Node tail;
		
		head = tail = new Node(10);
		tail.next = new Node(20);	tail = tail.next;
		tail.next = new Node(30);	tail = tail.next;
		tail.next = new Node(40);	tail = tail.next;
		tail.next = new Node(40);	tail = tail.next;
		tail.next = new Node(50);	tail = tail.next;
		
		HelperClass obj = new HelperClass();
		
		obj.printList(head);
		head = removeDuplicatesSortedList(head);
		obj.printList(head);
		
		System.out.println();
		tail.next = new Node(20);	tail = tail.next;
		tail.next = new Node(15);	tail = tail.next;
		
		obj.printList(head);
		head = removeDuplicatesUnsortedList(head);
		obj.printList(head);
	}
}
