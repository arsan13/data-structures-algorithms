package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestGreatestLeft {

	public static void main(String args[]) {
		
		int arr[] = { 10, 40, 25, 15, 30, 35 };
		int n= arr.length;
		List<Integer> list = new ArrayList<Integer>();

		list = naive(arr, n);
		System.out.println(list);
		
		list = efficient(arr, n);
		System.out.println(list);
		
	}

	private static List<Integer> efficient(int[] arr, int n) {
		
		Stack<Integer> stack = new  Stack<>();
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) 
		{		
			while(!stack.isEmpty() && stack.peek() <= arr[i])
				stack.pop();
			int value = stack.isEmpty() ?-1 : stack.peek();
			list.add(value);
			stack.push(arr[i]);
		}
		return list;
	}

	private static List<Integer> naive(int[] arr, int n) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j >= 0; j--) {
				
				if(j == 0)
					list.add(-1);
	
				if(arr[i] < arr[j]) {
					list.add(arr[j]);
					break;
				}				
			}
		}
		return list;
	}
}
