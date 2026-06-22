package backtracking.level2.words;

import java.util.HashMap;
import java.util.Map;

public class WordPatternMatching {

	private static void match(String str, String pattern, int index, Map<Character, String> map) {
		
		if(index == pattern.length()) {
			if(str.length() == 0)
				System.out.println(map);
			return;
		}
		
		char ch = pattern.charAt(index);
		index++;
		
		if(map.containsKey(ch)) {
			String presentString = map.get(ch);
			
			if(str.length() >= presentString.length()) {
				String left = str.substring(0, presentString.length());
				String right = str.substring(presentString.length());
				
				if(presentString.equals(left)) 
					match(right, pattern, index, map);
			}
		}
		else {
			for (int i = 0; i < str.length(); i++) {
				String left = str.substring(0, i + 1);
				String right = str.substring(i + 1);
				
				map.put(ch, left);
				match(right, pattern, index, map);
				map.remove(ch);
			}
		}
	}
	
	public static void main(String[] args) {

		String str	= "GeeksforGeeks";
		String pattern = "GfG";
		Map<Character, String> map = new HashMap<>();
		match(str, pattern, 0, map);
	}
}
