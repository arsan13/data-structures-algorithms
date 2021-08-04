package linkedList;

// Add one to the given linked list and return the head of the resultant linked list.
public class AddOneToList {

	private static Node addOne(Node head) {
		if(head == null) {
			return null;
		}
		
		Node reverseHead = reverseList(head); 
		Node temp = reverseHead;
		Node prev = null;
		
		int carry = 1;
		while(temp != null) {
			int sum = temp.data + carry;
			carry = sum / 10; 	//carry = sum > 9 ? 1 : 0
			sum = sum % 10;
			
			temp.data = sum;
			prev = temp;
			temp = temp.next;
		}
		
		if(carry > 0) {
			prev.next = new Node(1); 
		}
		
		return reverseList(reverseHead);
	}
	
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
		
		head = tail = new Node(1);
		tail.next = new Node(2);	tail = tail.next;
		tail.next = new Node(3);	tail = tail.next;
		tail.next = new Node(9);	tail = tail.next;
		tail.next = new Node(9);	tail = tail.next;
		
		HelperClass obj = new HelperClass();
		
		obj.printList(head);
		head = addOne(head);
		obj.printList(head);
	}
}
