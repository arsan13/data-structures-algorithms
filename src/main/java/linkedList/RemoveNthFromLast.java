package linkedList;

public class RemoveNthFromLast {

	// One pass algorithm
	private static Node removeNthFromLast2(Node head, int n) {
		Node dummy = new Node(0);
	    dummy.next = head;

	    Node fast = dummy;
	    Node slow = dummy;
	    for (int i = 1; i <= n + 1; i++) {
	        fast = fast.next;
	    }
	    
	    while (fast != null) {
	        fast = fast.next;
	        slow = slow.next;
	    }
	    
	    slow.next = slow.next.next;
	    return dummy.next;
	}
	
	// Two pass algorithm
	private static Node removeNthFromLast1(Node head, int n) {
		Node dummy = new Node(0);
		dummy.next = head;
		Node node = head;
		int length = 0;
		
		while (node != null) {
			node = node.next;
			length++;
		}
		
		node = dummy;
		length = length - n;
		while (length > 0) {
			length--;
			node = node.next;
		}
		
		node.next = node.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {

		int n = 2;
		Node head;
		Node tail;
		
		head = tail = new Node(10);
		tail.next = new Node(20);	tail = tail.next;
		tail.next = new Node(30);	tail = tail.next;
		tail.next = new Node(40);	tail = tail.next;
		tail.next = new Node(50);	tail = tail.next;
		
		HelperClass obj = new HelperClass();
		
		obj.printList(head);
//		head = removeNthFromLast1(head, n);
		head = removeNthFromLast2(head, n);
		obj.printList(head);
	}

}
