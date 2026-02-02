package backtracking.level2.words;

import java.util.HashSet;
import java.util.Set;

//Repitation not allowed
public class WordsKSelection2 {

	private static void distinct(String str, int k) {

		Set<Character> set = new HashSet<>();
		String uniqueStr = "";

		for (char ch : str.toCharArray()) {
			if (!set.contains(ch)) {
				set.add(ch);
				uniqueStr += ch;
			}
		}
		
		distinctUtil(-1, uniqueStr, 1, k, "");
	}

	private static void distinctUtil(int lastUsedIndex, String str, int count, int k, String ans) {

		if (count > k) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = lastUsedIndex + 1; i < str.length(); i++) {
			char ch = str.charAt(i);
			distinctUtil(i, str, count + 1, k, ans + ch);
		}
	}

	public static void main(String[] args) {

		int k = 2;
		String str = "abcabc";
		distinct(str, k);
	}
}
