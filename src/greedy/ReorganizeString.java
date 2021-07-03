package greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

	private static String reorganize(String str) {

		StringBuilder result = new StringBuilder();

		// 1. Get frequencies of of characters in the given string
		Map<Character, Integer> counts = new HashMap<>();
		for (char ch : str.toCharArray())
			counts.put(ch, counts.getOrDefault(ch, 0) + 1);

		// 2. Build max-heap according to most frequently occurring character
		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
		maxHeap.addAll(counts.keySet());

		while (maxHeap.size() > 1) {
			char current = maxHeap.poll(); // most frequently occurring character
			char next = maxHeap.poll();    // Second most frequently occurring character
			
			result.append(current);
			result.append(next);
			
			counts.put(current, counts.get(current) - 1);
			counts.put(next, counts.get(next) - 1);
			
			if(counts.get(current) > 0)
				maxHeap.add(current);
			if(counts.get(next) > 0)
				maxHeap.add(next);
		}
		
		// At the end, one character will be left out
		if(!maxHeap.isEmpty()) {
			char last = maxHeap.poll();
			if(counts.get(last) > 1)	// Reorganizing is not possible
				return "Not possible";
			else
				result.append(last);
		}

		return result.toString();
	}

	public static void main(String[] args) {

		String str = "aaabbcc";

		System.out.println(reorganize(str));
	}
}
