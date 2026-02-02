package greedy.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostOfRopes {

	public static int minCost(int arr[], int n) {
		Queue<Integer> heap = new PriorityQueue<>();

		for (int val : arr) {
			heap.add(val);
		}

		int res = 0;
		while (heap.size() > 1) {
			int a = heap.poll();
			int b = heap.poll();
			int sum = a + b;
			res += sum;
			heap.add(sum);
		}

		return res;
	}

	public static void main(String[] args) {

		int n = 4;
		int arr[] = { 4, 3, 2, 6 };
		
		System.out.println(minCost(arr,n));
	}

}
