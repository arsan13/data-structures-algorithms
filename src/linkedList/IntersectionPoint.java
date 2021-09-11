package linkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionPoint {
	
	// Extra Space
	private static int intersectPoint1(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;

		Set<Node> set = new HashSet<>();

		while (temp1 != null) {
			set.add(temp1);
			temp1 = temp1.next;
		}

		while (temp2 != null) {
			if (set.contains(temp2))
				return temp2.data;
			temp2 = temp2.next;
		}

		return -1;
	}

	// Constant Space
	private static int intersectPoint2(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;

		while (temp1 != temp2) {
			if (temp1 == null) {
				temp1 = head2;
			} else {
				temp1 = temp1.next;
			}

			if (temp2 == null) {
				temp2 = head1;
			} else {
				temp2 = temp2.next;
			}
		}

		return temp1 == null ? -1 : temp1.data;
	}

	public static void main(String[] args) {
		
		Node head1;
		Node head2;
		Node tail1;
		Node tail2;
		
		head1 = tail1 = new Node(1);
		tail1.next = new Node(2);	tail1 = tail1.next;
		tail1.next = new Node(5);	tail1 = tail1.next;
		
		head2 = tail2 = new Node(3);
		tail2.next = new Node(6);	tail2 = tail2.next;
		tail2.next = new Node(15);	tail2 = tail2.next;
		
		Node node = new Node(20);
		tail1.next = node;
		tail2.next = node;
		
		System.out.println(intersectPoint1(head1, head2));
		System.out.println(intersectPoint2(head1, head2));
	}
}
