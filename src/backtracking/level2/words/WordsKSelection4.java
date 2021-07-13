package backtracking.level2.words;

import java.util.HashMap;
import java.util.Map;

// K-length distinct words - Repitation allowed
public class WordsKSelection4 {

	private static void distinct(String str, int k) {

		Map<Character, Integer> fmap = new HashMap<>();
		String uniqueStr = "";

		for (char ch : str.toCharArray()) {
			if (fmap.containsKey(ch)) {
				fmap.put(ch, fmap.get(ch) + 1);
			} else {
				fmap.put(ch, 1);
				uniqueStr += ch;

			}
		}

		distinctUtil(0, uniqueStr, fmap, 0, k, "");
	}

	private static void distinctUtil(int lastUsedIndex, String str, Map<Character, Integer> fmap, int count, int k, String ans) {

		if(count == k) {
			System.out.print(ans + " ");
			return;
		}
		
		for(int i = lastUsedIndex; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (fmap.get(ch) > 0) {
				fmap.put(ch, fmap.get(ch) - 1);
				distinctUtil(i, str, fmap, count + 1, k, ans + ch);
				fmap.put(ch, fmap.get(ch) + 1);
			}
		}
	}

	public static void main(String[] args) {

		int k = 3;
		String str = "aaabbc";
		distinct(str, k);
	}
}
