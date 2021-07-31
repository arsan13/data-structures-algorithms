package slidingWindow;

import java.util.HashMap;
import java.util.Map;

// Find the longest substring with atmost k unique characters in a given string.
public class CountAtmostKUnique {

	private static int kUnique(String str, int k) {
		if(k > str.length())	// corner case
			return 0;
		
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();

		int i = 0;
		int j = 0;
		while (j < str.length()) {
			
			// 1. Acquire
			map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);

			// 2. Work
			if (map.size() <= k) {
				res += j - i + 1;
			}

			// 3. Release
			while (map.size() > k) {
				char ch = str.charAt(i);
				if (map.get(ch) > 1) {
					map.put(ch, map.get(ch) - 1);
				} else {
					map.remove(ch);
				}
				i++;
				
				if (map.size() <= k) {
					res += j - i + 1;
				}
			}

			j++;
		}

		return res;
	}

	public static void main(String[] args) {

		System.out.println(kUnique("aabcbcdbca", 2));
	}

}
