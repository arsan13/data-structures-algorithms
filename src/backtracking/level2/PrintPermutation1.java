package backtracking.level2;

import java.util.HashMap;
import java.util.Map;

// String with repeated character....n!/repeated_ch!

public class PrintPermutation1 {

	public static void permutations(String str) {

		Map<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray())
			map.put(ch, map.getOrDefault(ch, 0) + 1);

		permutationsUtil(0, str.length(), map, "");
	}

	private static void permutationsUtil(int spot, int totalSpots, Map<Character, Integer> map,
			String ans) {

		if (spot == totalSpots) {
			System.out.print(ans + " ");
			return;
		}
		
		for (char ch : map.keySet()) {
			if (map.get(ch) > 0) {
				map.put(ch, map.get(ch) - 1);
				permutationsUtil(spot + 1, totalSpots, map, ans+ch);
				map.put(ch, map.get(ch) + 1);
			}
		}
	}

	public static void main(String[] args) {

		permutations("aabb");
	}
}
