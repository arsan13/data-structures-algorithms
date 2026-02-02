package backtracking.level2.words;

import java.util.HashMap;
import java.util.Map;

public class PalindromicPermutation {

	private static void permutation(String str) {

		Map<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray())
			map.put(ch, map.getOrDefault(ch, 0) + 1);

		permutationsUtil(0, str.length(), map, "");
	}

	private static void permutationsUtil(int spots, int totalSpots, Map<Character, Integer> map, String ans) {
		
		if(spots == totalSpots) {
			if(isPalindrome(ans))
				System.out.print(ans + " ");
			return;
		}
		
		for(char ch : map.keySet()) {
			if(map.get(ch) > 0) {
				map.put(ch, map.get(ch)-1);
				permutationsUtil(spots+1, totalSpots, map, ans+ch);
				map.put(ch, map.get(ch)+1);
			}
		}
	}

	private static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		
		
		while(start < end) {
			if(str.charAt(start) != str.charAt(end)) 
				return false;
			start++;
			end--;
		}
		
		return true;
	}

	public static void main(String[] args) {

		String str = "abab";
		permutation(str);
	}
}
