package backtracking.level2.words;

import java.util.HashMap;
import java.util.Map;

// String with repeated character....n!/repeated_ch!

public class KLengthWords4 {

	public static void getWords(String str, int k) {

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

		getWordsUtil(0, uniqueStr, fmap, 0, k, "");
	}

	private static void getWordsUtil(int lastUsedIndex, String str, Map<Character, Integer> fmap, int count, int k,
			String ans) {

		if (count == k) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = lastUsedIndex; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (fmap.get(ch) > 0) {
				fmap.put(ch, fmap.get(ch) - 1);
				getWordsUtil(i, str, fmap, count + 1, k, ans + ch);
				fmap.put(ch, fmap.get(ch) + 1);
			}
		}
	}

	public static void main(String[] args) {

		getWords("aabbac", 3);
	}
}
