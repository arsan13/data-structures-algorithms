package backtracking.level2.words;

public class PalindromicPartition {

	private static void permutation(String str, String ans) {

		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String prefix = str.substring(0, i + 1);
			String ros = str.substring(i + 1);
			if (isPalindrome(prefix))
				permutation(ros, ans + "(" + prefix + ")");
		}
	}

	private static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;

		while (start < end) {
			if (str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}

		return true;
	}

	public static void main(String[] args) {

		String str = "abab";
		permutation(str, "");
	}
}
