package stack;

import java.util.Stack;

public class BalancedBracket {

	public static void main(String[] args) {
		
		String str = "{(([])[])[]]}";
		char ch;
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) 
		{
			ch = str.charAt(i);
			
			switch(ch) 
			{
				case '}' : 
					if(stack.peek() == '{')
						stack.pop();
					else
						stack.push(ch);
					break;
				case ')' :
					if(stack.peek() == '(')
						stack.pop();
					else
						stack.push(ch);
					break;
				case ']' : 
					if(stack.peek() == '[')
						stack.pop();
					else
						stack.push(ch);
					break;
				default:
					stack.push(ch);
			}
		}
		
		System.out.println(stack.isEmpty());
	}

}
