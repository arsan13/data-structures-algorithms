package dp.group5;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStrings {

	private static boolean isScrambled(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.isEmpty() && s2.isEmpty())
			return true;

		Map<String, Boolean> dpMap = new HashMap<>();
		return solve(s1, s2, dpMap);
	}

	private static boolean solve(String s1, String s2, Map<String, Boolean> dpMap) {
		if (s1.equals(s2))
			return true;
		if (s1.length() <= 1)
			return false;

		String key = s1 + "#" + s2;
		if(dpMap.containsKey(key))
			return dpMap.get(key);
		
		int n = s1.length();
		boolean flag = false;
		for (int i = 1; i < n; i++) {
			boolean swap = solve(s1.substring(0, i), s2.substring(n - i, n), dpMap)
					&& solve(s1.substring(i, n), s2.substring(0, n - i), dpMap);
			boolean noSwap = solve(s1.substring(0, i), s2.substring(0, i), dpMap)
					&& solve(s1.substring(i, n), s2.substring(i, n), dpMap);

			if (swap == true || noSwap == true) {
				flag = true;
				break;
			}
		}

		dpMap.put(key, flag);
		return flag;
	}

	public static void main(String[] args) {

		String s1 = "great";
		String s2 = "rgeat";

		System.out.println(isScrambled(s1, s2));
	}

}
