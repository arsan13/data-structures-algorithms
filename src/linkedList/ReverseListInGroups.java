package linkedList;

public class ReverseListInGroups {
	
	private static Node reverseInGroups(Node head, int k) {
		if(head == null || head.next == null || k < 1) {
			return head;
		}
		
		Node following = null;
		Node previous = null;
		Node current = head;
		int count = 0;
		
		while(current != null && count < k) {
			following = current.next;
			current.next = previous;
			previous = current;
			current = following;
			count++;
		}
		
		if(following != null) {
			head.next = reverseInGroups(following, k);
		}
		
		return previous;
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
		head = reverseInGroups(head, k);
		obj.printList(head);
	}
}
