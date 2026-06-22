
package linkedList;

// Add two numbers represented by linked list.
public class MergeTwoLists {

	private static Node mergeByRecursion(Node head1, Node head2) {
		if(head1 == null) 
			return head2;
		if(head2 == null) 
			return head1;
		
		if(head1.data <= head2.data) {
			head1.next = mergeByRecursion(head1.next, head2);
			return head1;
		} else {
			head2.next = mergeByRecursion(head1, head2.next);
			return head1;
		}
	}
	
	private static Node mergeByIteration(Node head1, Node head2) {
		if(head1 == null && head2 == null) {
			return null;
		}
	
		Node dummy =  new Node(0);
		Node temp = dummy;
		Node curr1 = head1;
		Node curr2 = head2;
		
		while(curr1 != null && curr2!= null) {
			if(curr1.data <= curr2.data) {
				temp.next = curr1;
				curr1 = curr1.next;
			} else {
				temp.next = curr2;
				curr2 = curr2.next;
			}
			
			temp = temp.next;
		}
		
		while(curr1 != null) {
            temp.next = curr1;
            temp = temp.next;
            curr1 = curr1.next;
		}
		while(curr2 != null) {
			temp.next = curr2;
			temp = temp.next;
            curr2 = curr2.next;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {

		Node head1;
		Node head2;
		Node tail;
		
		head1 = tail = new Node(1);
		tail.next = new Node(2);	tail = tail.next;
		tail.next = new Node(5);	tail = tail.next;
		
		head2 = tail = new Node(3);
		tail.next = new Node(6);	tail = tail.next;
		tail.next = new Node(15);	tail = tail.next;
		tail.next = new Node(20);	tail = tail.next;
		
		HelperClass obj = new HelperClass();
		
		obj.printList(head1);
		obj.printList(head2);
//		Node node = mergeByIteration(head1, head2);
		Node node = mergeByRecursion(head1, head2);
		obj.printList(node);
	}
}
