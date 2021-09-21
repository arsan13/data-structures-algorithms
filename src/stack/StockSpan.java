package stack;

import java.util.Stack;

// Link of the problem statement: 
// https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
public class StockSpan {

	public static void main(String args[]) {
		
		int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
		int n= arr.length;
		int result[] = new int[n];
		
		result = efficient(arr, n, result);	
		
		for(int i : result)
			System.out.print(i + " ");
	}

	private static int[] efficient(int[] arr, int n, int result[]) {
		
		Stack<Integer> stack = new  Stack<>();
		int k = 0;
		
		result[k++] = 1;
		stack.push(0);
		
		for (int i = 1; i < n; i++) 
		{		
			while(!stack.isEmpty() && arr[stack.peek()] <= arr[i])
				stack.pop();
			int value = stack.isEmpty() ? (i + 1) :  (i - stack.peek());
			result[k++] = value;
			stack.push(i);
		}
		
		return result;
	}
}
