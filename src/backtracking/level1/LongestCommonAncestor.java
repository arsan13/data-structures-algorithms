package backtracking.level1;

public class LongestCommonAncestor {

	private static int lca(String str1, String str2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;
		if (str1.charAt(n - 1) == str2.charAt(m - 1))
			return 1 + lca(str1, str2, n - 1, m - 1);
		
		return Math.max(lca(str1, str2, n - 1, m), lca(str1, str2, n, m - 1));
	}

	public static void main(String[] args) {

		String str1 = "abbacd";
		String str2 = "cbbac";
		System.out.println(lca(str1, str2, str1.length(), str2.length()));
	}

}
