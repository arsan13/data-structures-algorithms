package stack.implementation;

public class StackRun {

	public static void main(String[] args) {

		StackUsingLinkedList obj = new StackUsingLinkedList();
		
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		
		
		System.out.println(obj.peek());
		obj.pop();
		System.out.println(obj.peek());
	
	}

}
