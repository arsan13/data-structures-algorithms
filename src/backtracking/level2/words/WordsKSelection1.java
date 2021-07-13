package backtracking.level2.words;

import java.util.HashSet;
import java.util.Set;

// K-length distinct words - Repitation not allowed
public class WordsKSelection1 {

	private static void distinct(String str, int k) {
		
		Set<Character> set = new HashSet<>();
		String uniqueStr = "";
		
		for(char ch : str.toCharArray()) {
			if(!set.contains(ch)) {
				set.add(ch);
				uniqueStr  += ch;
			}
		}
				
		distinctUtil(0, uniqueStr, 0, k, "");
	}
	
	private static void distinctUtil(int index, String str, int count, int k, String ans) {
	
		if(index == str.length()) {
			if(count == k) 
				System.out.print(ans + " ");
			return;
		}
		
		char ch = str.charAt(index);
		distinctUtil(index + 1, str, count + 1, k, ans + ch);
		distinctUtil(index + 1, str, count + 0, k, ans + "");
	}
	
	public static void main(String[] args) {

		int k = 2;
		String str = "abcabc";
		distinct(str, k);
	}
}
