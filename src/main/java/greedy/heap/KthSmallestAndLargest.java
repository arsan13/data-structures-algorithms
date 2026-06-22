package greedy.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestAndLargest {

	private static int kthLargest(int[] arr, int k) {
		if(arr.length < k)
			return -1;
		
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		for(int val : arr) {
			minQueue.add(val);
			
			if(minQueue.size() > k) {
				minQueue.poll();
			}
		}
		
		return minQueue.peek();
	}

	private static int kthSmallest(int[] arr, int k) {
		if(arr.length < k)
			return -1;
		
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
		for(int val : arr) {
			maxQueue.add(val);
			
			if(maxQueue.size() > k) {
				maxQueue.poll();
			}
		}
		
		return maxQueue.peek();
	}
	
	public static void main(String[] args) {

		int k = 2;
		int arr[] = { 3, 2, 1, 5, 6, 4 };
		
		System.out.println("Kth Largest: " + kthLargest(arr, k));
		System.out.println("Kth Smallest: " + kthSmallest(arr, k));
	}
}
