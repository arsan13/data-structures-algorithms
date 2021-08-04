package linkedList;

public class ReverseList {

	private static Node reverseList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node following = null;
		Node previous = null;
		Node current = head;
		
		while(current != null) {
			following = current.next;
			current.next = previous;
			previous = current;
			current = following;
		}
		
		return previous;
	}
	
	public static void main(String[] args) {

		Node head;
		Node tail;
		
		head = tail = new Node(10);
		tail.next = new Node(20);	tail = tail.next;
		tail.next = new Node(30);	tail = tail.next;
		tail.next = new Node(40);	tail = tail.next;
		tail.next = new Node(50);	tail = tail.next;
		
		HelperClass obj = new HelperClass();
		
		obj.printList(head);
		head = reverseList(head);
		obj.printList(head);
	}
}
