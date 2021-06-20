package stack;

import java.util.*;

public class InfixToPostfix {

	public static void main(String[] args) {

		Stack<Character> stack = new Stack<>();
		String str = "a+b*(c^d-e)^(f+g*h)-i";
		String result = "";
		char ch;

		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);

			if (Character.isLetterOrDigit(ch)) {
				result += ch;
			} 
			else if (ch == '(')
				stack.push(ch);
			else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();
				stack.pop();
			} 
			else {
				while (!stack.isEmpty() && prec(ch) <= prec(stack.peek())) {
					result += stack.pop();
				}
				stack.push(ch);
			}
		}

		while (stack.isEmpty() == false) {
			if (stack.peek() != '(')
				result += stack.pop();
		}

		System.out.println(result);
	}

	static int prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}
}
