package greedy.heap;

import java.util.PriorityQueue;

public class SortKSortedArray {

	private static void sort(int arr[], int k) {
		int index = 0;
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		
		for(int val : arr) {
			minQueue.add(val);
			
			if(minQueue.size() > k) {
				arr[index++] = minQueue.poll();
			}
		}
		
		while(!minQueue.isEmpty()) {
			arr[index++] = minQueue.poll();
		}
	}
	
	public static void main(String[] args) {
		
		int k = 3 ;
		int arr[] = {6, 5, 3, 2, 8, 10, 9};
		
		sort(arr, k);		
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}

}
