package stack;

import java.util.Stack;

public class ReverseStack {

	private static void reverse(Stack<Integer> stack) {
		if(stack.size() == 0)
			return;
		
		Integer temp = stack.pop();
		reverse(stack);
		insert(stack, temp);
	}
	
	private static void insert(Stack<Integer> stack, Integer num) {
		if(stack.size() == 0) {
			stack.push(num);
			return;
		}
		
		Integer temp = stack.pop();
		insert(stack, num);
		stack.push(temp);
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		System.out.println(stack);
		reverse(stack);
		System.out.println(stack);
	}

}
