package stack;

import java.util.Stack;

public class SortStack {

	private static void sortByRecursion(Stack<Integer> stack) {
		if(stack.size() == 0)
			return;
		
		Integer temp = stack.pop();
		sortByRecursion(stack);
		insert(stack, temp);
	}
	
	private static void insert(Stack<Integer> stack, Integer num) {
		if(stack.size() == 0 || stack.peek() <= num) {
			stack.push(num);
			return;
		}
		
		Integer temp = stack.pop();
		insert(stack, num);
		stack.push(temp);
	}
	
	private static void sortByTempStack(Stack<Integer> stack) {
		if(stack.isEmpty())
			return;
		
		Stack<Integer> tempStack = new Stack<>();
		while(!stack.isEmpty()) {
			Integer element = stack.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > element) {
				stack.push(tempStack.pop());
			} 
			tempStack.push(element);
		}
		
		stack.addAll(tempStack);
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(20);
		stack.push(40);
		stack.push(10);
		stack.push(30);
		
//		sortByRecursion(stack);
		sortByTempStack(stack);
		System.out.println(stack);
	}

}
