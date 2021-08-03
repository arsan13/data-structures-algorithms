package stack;

import java.util.Stack;

//@SuppressWarnings("serial")
//class SpecialStackExtraSpace extends Stack<Integer> {
//
//	Stack<Integer> supportingStack = new Stack<>(); // stores only minimum element
//	
//	public void push(int element) {
//		super.push(element);
//		
//		if(supportingStack.isEmpty() || supportingStack.peek() >= element)
//			supportingStack.push(element);
//	}
//
//	public Integer pop() {
//		
//		if(super.isEmpty())
//			return -1;
//		
//		int ans = super.pop(); 
//		
//		if(ans == supportingStack.peek())
//			supportingStack.pop();
//		
//		return ans;
//	}
//
//	public int min() {
//		
//		if(supportingStack.isEmpty())
//			return -1;
//		
//		return supportingStack.peek();
//	}
//}

class SpecialStackExtraSpace {

	Stack<Integer> stack = new Stack<>();
	Stack<Integer> supportingStack = new Stack<>(); // stores only minimum element

	public void push(int element) {
		stack.push(element);

		if (supportingStack.isEmpty() || supportingStack.peek() >= element) {
			supportingStack.push(element);
		}
	}

	public Integer pop() {
		if (stack.isEmpty()) {
			return -1;
		}
		int ans = stack.pop();
		if (ans == supportingStack.peek()) {
			supportingStack.pop();
		}
		return ans;
	}

	public int min() {
		if (supportingStack.isEmpty()) {
			return -1;
		}
		return supportingStack.peek();
	}
}

public class MinStackWithExtraSpace {

	public static void main(String[] args) {

		SpecialStackExtraSpace myStack = new SpecialStackExtraSpace();

		myStack.push(10);
		myStack.push(20);
		myStack.push(5);

		myStack.pop();

		System.out.println(myStack.min());

	}
}
