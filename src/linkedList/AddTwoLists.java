
package linkedList;

// Add two numbers represented by linked list.
public class AddTwoLists {

	private static Node addTwoLists(Node head1, Node head2) {
		if(head1 == null && head2 == null) {
			return null;
		}
		
		head1 = reverseList(head1); 
		head2 = reverseList(head2); 
		
		Node curr1 = head1;
		Node curr2 = head2;
		Node dummy =  new Node(0);
		Node temp = dummy;
		
		int sum = 0;
		int carry = 0;
		while(curr1 != null || curr2 != null) {
			sum = (curr1 != null ? curr1.data : 0) + (curr2 != null ? curr2.data : 0) + carry;
			carry = sum / 10; 	//carry = sum > 9 ? 1 : 0
			sum = sum % 10;
			
			temp.next = new Node(sum);
			temp = temp.next; 
			
			if(curr1 != null) 
                curr1 = curr1.next;
			if(curr2 != null) 
				curr2 = curr2.next;
		}
		
		if(carry > 0) {
			temp.next = new Node(carry);
		}
		
		return reverseList(dummy.next);
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

		Node head1;
		Node head2;
		Node tail;
		
		head1 = tail = new Node(1);
		tail.next = new Node(2);	tail = tail.next;
		tail.next = new Node(5);	tail = tail.next;
		
		head2 = tail = new Node(3);
		tail.next = new Node(5);	tail = tail.next;
		
		HelperClass obj = new HelperClass();
		
		obj.printList(head1);
		obj.printList(head2);
		head1 = addTwoLists(head1, head2);
		System.out.print("Sum = ");
		obj.printList(head1);
	}
}
