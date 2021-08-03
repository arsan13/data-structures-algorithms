package greedy.heap;

import java.util.PriorityQueue;

public class KClosestNumbers {

	private static class Pair {
		int key;
		int diff;

		public Pair(int key, int diff) {
			this.key = key;
			this.diff = diff;
		}
	}

	private static void kClosest(int arr[], int k, int x) {
		if(arr.length < k)
			return;
		
		PriorityQueue<Pair> maxQueue = new PriorityQueue<>((a, b) -> b.diff - a.diff);
		for(int val : arr) {
			Pair p = new Pair(val, Math.abs(x - val));
			maxQueue.add(p);
			
			if(maxQueue.size() > k) {
				maxQueue.poll();
			}
		}
		
		while(!maxQueue.isEmpty()) {
			System.out.print(maxQueue.poll().key + " ");
		}
	}

	public static void main(String[] args) {

		int k = 4;
		int x = 35;
		int arr[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };

		kClosest(arr, k, x);
	}

}
