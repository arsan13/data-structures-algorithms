package slidingWindow;

import java.util.*;

// Smallest window of string s containing all characters of string p;
public class MinWindowSubstring1 {

	private static int findMinWindow(String s, String t) {

		String res = "";
		Map<Character, Integer> map = new HashMap<>();
		for (int k = 0; k < t.length(); k++) {
			char ch = t.charAt(k);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int count = map.size();

		int i = 0, j = 0;
		while (j < s.length()) {
			char ch = s.charAt(j);

			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0) {
					count--;
				}
			}

			while (count == 0) { // required window, try to optimize

				int windowSize = j - i + 1;
				if (res.equals("") || res.length() > windowSize) {
					res = s.substring(i, j + 1);
				}

				if (map.containsKey(s.charAt(i))) {
					map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
					if (map.get(s.charAt(i)) > 0) {
						count++;
					}
				}

				i++;
			}
			j++;
		}

		System.out.println(res);
		return res.length();
	}

	public static void main(String[] args) {
		String str = "timetopractice";
		String t = "toc";
		int ans = findMinWindow(str, t);
		System.out.println("Minimum window: " + ans);
	}
}
