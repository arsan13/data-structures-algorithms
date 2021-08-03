package greedy.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

	private static class Pair {
		int element;
		int frequency;

		public Pair(int element, int frequency) {
			this.element = element;
			this.frequency = frequency;
		}
	}

	private static void sort(int arr[]) {
		if(arr.length == 0)
			return;
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int val : arr) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		PriorityQueue<Pair> maxQueue = new PriorityQueue<>((a, b) -> {
			if (a.frequency == b.frequency)
				return a.element - b.element;
			return b.frequency - a.frequency;
		});

		for (int key : map.keySet()) {
			Pair p = new Pair(key, map.get(key));
			maxQueue.add(p);
		}

		int index = 0;
		while (!maxQueue.isEmpty()) {
			Pair p = maxQueue.poll();
			for (int i = 0; i < p.frequency; i++) {
				arr[index++] = p.element;
			}
		}
	}

	public static void main(String[] args) {

		int k = 2;
		int arr[] = { 1, 1, 1, 2, 2, 3 };

		sort(arr);
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

}
