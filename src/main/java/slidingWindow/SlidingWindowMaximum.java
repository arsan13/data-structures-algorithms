package slidingWindow;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

// Given an array and an integer k, find the maximum for each and every contiguous sub-array of size k.
public class SlidingWindowMaximum {

	// O(nLogk) time | O(k) space
	private static int[] maxSlidingWindow1(int[] arr, int k) {
		if (k > arr.length)
			return new int[] {};

		int index = 0;
		int[] res = new int[arr.length - k + 1];
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

		int i = 0;
		int j = 0;
		while (j < arr.length) {
			maxQueue.add(arr[j]);

			if (j - i + 1 == k) {
				res[index++] = maxQueue.peek();
				maxQueue.remove(arr[i]);
				i++;
			}

			j++;
		}

		return res;
	}

	// Efficient | O(n) time | O(k) space
	private static int[] maxSlidingWindow2(int[] arr, int k) {
		int n = arr.length;
		if (k > n)
			return new int[] {};

		int index = 0;
		int res[] = new int[n - k + 1]; // n-k+1 is the total number of windows
		Deque<Integer> queue = new LinkedList<>();

		int i = 0;
		int j = 0;
		while (j < n) {
			while (!queue.isEmpty() && queue.peekLast() < arr[j]) {
				queue.removeLast();
			}
			queue.addLast(arr[j]);

			if (j - i + 1 == k) {
				res[index++] = queue.peekFirst();
				if (arr[i] == queue.peekFirst())
					queue.removeFirst();
				i++;
			}

			j++;
		}

		return res;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;

		int[] res1 = maxSlidingWindow2(arr, k);
		for (int val : res1)
			System.out.print(val + " ");
		
		System.out.println();
		
		int[] res2 = maxSlidingWindow2(arr, k);
		for (int val : res2)
			System.out.print(val + " ");
	}
}
