package slidingWindow;

import java.util.*;

// Smallest window of string s containing all characters of string p;
public class MinWindowSubstring1 {

	private static String minWindowNew(String s, String t) {

		Map<Character, Integer> map = new HashMap<>();
		int len = Integer.MAX_VALUE;
		int startIndex = -1;
		int count = 0;

		for(char ch : t.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int l = 0;
		int r = 0;
		while(r < s.length()) {
			if(map.getOrDefault(s.charAt(r), 0) > 0) {
				count++;
			}
			map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);

			while(count == t.length()) {
				if ((r - l + 1) < len) {
					len = (r - l + 1);
					startIndex = l;
				}

				map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
				if(map.get(s.charAt(l)) > 0) {
					count--;
				}

				l++;
			}

			r++;
		}

		return startIndex == -1 ? "" : s.substring(startIndex, startIndex + len);
	}

	private static String findMinWindow(String s, String t) {

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
				if (res.isEmpty() || res.length() > windowSize) {
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

		return res;
	}

	public static void main(String[] args) {
		String str = "timetopractice";
		String t = "toc";
		String ans = findMinWindow(str, t);
		System.out.println("Minimum window 1: " + ans);
		ans = minWindowNew(str, t);
		System.out.println("Minimum window 2: " + ans);
	}
}
