package linkedList.implementation;

public class DoublyLinkedList {
	static class Node {
		int data;
		Node next, prev;

		public Node(int data) {
			this.data = data;
			next = prev = null;
		}
	}

	Node head;

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			head = newNode;
			return;
		}

		head.prev = newNode;
		newNode.next = head;
		head = newNode;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			head = newNode;
			return;
		}

		Node temp = head;
		while (temp.next != null)
			temp = temp.next;

		temp.next = newNode;
		newNode.prev = temp;
	}

	public void deleteFirst() {
		if (isEmpty())
			return;

		head = head.next;
		head.prev = null;
	}

	public void deleteLast() {
		if (isEmpty())
			return;

		Node temp = head;
		while (temp.next.next != null)
			temp = temp.next;

		temp.next = null;
	}

	public boolean search(int data) {
		if (isEmpty()) {
			return false;
		}

		Node temp = head;
		while (temp != null) {
			if (temp.data == data)
				return true;
			temp = temp.next;
		}

		return false;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Empty");
			return;
		}

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
