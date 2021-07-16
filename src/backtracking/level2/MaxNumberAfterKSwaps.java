package backtracking.level2;

public class MaxNumberAfterKSwaps {

	static String ans = "0";
	
	private static void findMax(String str, int k) {
		
		if(Integer.parseInt(str) > Integer.parseInt(ans)) {
			ans = str;
		}
		
		if(k == 0)
			return;
		
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if(str.charAt(j) > str.charAt(i)) {
					str = swap(str, i, j);
					findMax(str, k - 1);
					str = swap(str, i, j);
				}
			}
		}
	}
	
	private static String swap(String str, int i, int j) {
		
		StringBuilder res = new StringBuilder(str);
		res.setCharAt(i, str.charAt(j));
		res.setCharAt(j, str.charAt(i));
		return res.toString();
	}

	public static void main(String[] args) {

		findMax("1234567", 4);
		System.out.println(ans);
	}
}
