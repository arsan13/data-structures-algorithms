package backtracking.level2.words;

import java.util.HashSet;
import java.util.Set;

//All K-length words - Repitation not allowed
public class KLengthWords2 {

	private static void getWords(String str, int k) {

		Set<Character> set = new HashSet<>();
		String uniqueStr = "";

		for (char ch : str.toCharArray()) {
			if (!set.contains(ch)) {
				set.add(ch);
				uniqueStr += ch;
			}
		}

		System.out.println(factorial(set.size()) / factorial(set.size() - k));

		getWordsUtil(uniqueStr, 0, k, new HashSet<>(), "");
	}

	private static void getWordsUtil(String str, int count, int k, HashSet<Character> used, String ans) {

		if(count == k) {
			System.out.print(ans + " ");
			return;
		}
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(!used.contains(ch)) {
				used.add(ch);
				getWordsUtil(str, count+1, k, used, ans+ch);
				used.remove(ch);
			}
		}
	}

	private static int factorial(int n) {
		if (n == 0)
			return 1;

		return n * factorial(n - 1);
	}

	public static void main(String[] args) {

		int k = 3;
		String str = "aabbac";
		getWords(str, k);
	}
}
