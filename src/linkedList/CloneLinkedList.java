package linkedList;

import java.util.HashMap;
import java.util.Map;

//Clone a linked list with next and random/arbitrary pointer
public class CloneLinkedList {
	static private class Node {
		int data;
		Node next, arb;

		public Node(int data) {
			this.data = data;
		}
	}

	//O(n) Space
	public static Node cloneWithSpace(Node head) {
		Map<Node, Node> map = new HashMap<>();

		Node original = head;
		Node clone = null;
		while (original != null) {
			clone = new Node(original.data);
			map.put(original, clone);
			original = original.next;
		}

		original = head;
		while (original != null) {
			clone = map.get(original);
			clone.next = map.get(original.next);
			clone.arb = map.get(original.arb);
			original = original.next;
		}

		return map.get(head);
	}

	//O(1) Space
	public static Node cloneWithoutSpace(Node head) {

		if (head == null)
			return null;
		
		/* Create the copy of node 1 and insert it between node 1 & node 2 in original
		 * Linked List, create the copy of 2 and insert it between 2 & 3 and so on. */
		Node original = head;
		while (original != null) {
			Node newNode = new Node(original.data);
			newNode.next = original.next;
			original.next = newNode;
			original = original.next.next;
		}

		/* Copy the arbitrary link. 
		 * original.next.arbitrary = original.arbitrary.next. */
		original = head;
		while (original != null) {
			if (original.next != null)
				original.next.arb = (original.arb != null) ? original.arb.next : null; 
			original = (original.next != null) ? original.next.next : null;	
		}

		/* Restore the original and copy linked lists. 
		 * original.next = original.next.next; 
		 * copy.next = copy.next.next; */
		original = head;
		Node clone = original.next;
		Node tempCopy = clone;
		while (original != null && tempCopy != null) {
			original.next = (original.next != null) ? original.next.next : null;
			tempCopy.next = (tempCopy.next != null) ? tempCopy.next.next : null;

			original = original.next;
			tempCopy = tempCopy.next;
		}

		return clone;
	}
}
