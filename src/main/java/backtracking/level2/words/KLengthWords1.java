package backtracking.level2.words;

import java.util.HashSet;
import java.util.Set;

// All K-length words - Repitation not allowed
public class KLengthWords1 {

	private static void getWords(String str, int k) {

		Set<Character> set = new HashSet<>();
		Character[] spots = new Character[k];
		String uniqueStr = "";

		for (char ch : str.toCharArray()) {
			if (!set.contains(ch)) {
				set.add(ch);
				uniqueStr += ch;
			}
		}

		System.out.println(factorial(set.size()) / factorial(set.size() - k));

		getWordsUtil(0, uniqueStr, 0, k, spots);
	}

	private static void getWordsUtil(int lastUsedIndex, String str, int count, int k, Character[] spots) {

		if (lastUsedIndex == str.length()) {
			if (count == k) {
				for (char ch : spots)
					System.out.print(ch);
			}
			System.out.print(" ");
			return;
		}

		char ch = str.charAt(lastUsedIndex);
		for (int i = 0; i < spots.length; i++) {
			if (spots[i] == null) {
				spots[i] = ch;
				getWordsUtil(lastUsedIndex + 1, str, count + 1, k, spots);
				spots[i] = null;
			}
		}

		getWordsUtil(lastUsedIndex + 1, str, count + 0, k, spots);
	}

	private static int factorial(int n) {
		if (n == 0)
			return 1;

		return n * factorial(n - 1);
	}

	public static void main(String[] args) {

		int k = 2;
		String str = "abcabc";
		getWords(str, k);
	}
}
