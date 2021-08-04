package linkedList.implementation;

public class MainClass {

	public static void main(String[] args) {

		DoublyLinkedList obj = new DoublyLinkedList();

		obj.addFirst(20);
		obj.addLast(30);
		obj.addLast(40);
		obj.addFirst(10);

		System.out.println(obj.search(20));

		obj.deleteLast();

		obj.display();

	}

}
