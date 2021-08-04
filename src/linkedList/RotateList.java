package linkedList;

//Given the head of a linked list, rotate the list to the right by k places.
public class RotateList {

	private static Node rotateList(Node head, int k) {
		if(head == null || head.next == null || k < 1) {
			return head;
		}
		
		// Compute length
		int len = 1;
		Node current = head;	
		while(current.next != null) {
			current = current.next;
			len++;
		}
		
		// Make list circular
		current.next = head;
		
		// if k > len
		k = k % len;
		
		// travel till the (k-1)th node from last, make its next node as head and make (k-1)th as last node.
		k = len - k; // remove this to rotate list from left
		while(k-- > 0) {
			current = current.next;
		}
		head = current.next;
		current.next = null;
		
		return head;
	}
	
	public static void main(String[] args) {

		int k = 2;
		Node head;
		Node tail;
		
		head = tail = new Node(10);
		tail.next = new Node(20);	tail = tail.next;
		tail.next = new Node(30);	tail = tail.next;
		tail.next = new Node(40);	tail = tail.next;
		tail.next = new Node(50);	tail = tail.next;
		
		HelperClass obj = new HelperClass();
		
		obj.printList(head);
		head = rotateList(head, k);
		obj.printList(head);
	}
}
