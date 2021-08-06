package linkedList;

public class SplitCLLIntoHalves {

	private static void splitCLL(Node head) {
		if(head == null || head.next == null)
			return;
		
		Node slow = head; 
		Node fast = head;
        while(fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // For even number of elements
        if(fast.next != head)
            fast = fast.next;
        
        Node head2 = slow.next;  // head pointer of second half
        fast.next = head2;		 // second half circular
        slow.next = head;		 // first half circular
        
        HelperClass obj = new HelperClass();
        obj.printCLL(head);
        obj.printCLL(head2);
		
	}
	
	public static void main(String[] args) {

		Node head;
		Node tail;
		
		head = tail = new Node(10);
		tail.next = new Node(20);	tail = tail.next;
		tail.next = new Node(30);	tail = tail.next;
		tail.next = new Node(40);	tail = tail.next;
		tail.next = new Node(50);	tail = tail.next;
		tail.next = head;
		
		new HelperClass().printCLL(head);
		splitCLL(head);
	}
}
