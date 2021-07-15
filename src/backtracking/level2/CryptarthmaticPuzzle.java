package backtracking.level2;

import java.util.Map;
import java.util.TreeMap;

public class CryptarthmaticPuzzle {

	private static void printPuzzles(String s1, String s2, String s3) {
		
		String uniqueStr = "";
		boolean[] digitUsed = new boolean[10];
		Map<Character, Integer> map = new TreeMap<>();
		
		for(char ch : s1.toCharArray()) {
			if(!map.containsKey(ch)) {
				map.put(ch, -1);
				uniqueStr += ch; 
			}
		}

		for(char ch : s2.toCharArray()) {
			if(!map.containsKey(ch)) {
				map.put(ch, -1);
				uniqueStr += ch; 
			}
		}
		
		for(char ch : s3.toCharArray()) {
			if(!map.containsKey(ch)) {
				map.put(ch, -1);
				uniqueStr += ch; 
			}
		}
		
		printpuzzlesUtil(s1, s2, s3, 0, uniqueStr, map, digitUsed);
	}
	
	private static void printpuzzlesUtil(String s1, String s2, String s3, int index, String uniqueStr, Map<Character, Integer> map, boolean[] digitUsed) {
		
		if(index == uniqueStr.length()) {
			
			int num1 = getNum(s1, map);
			int num2 = getNum(s2, map);
			int num3 = getNum(s3, map);
		
			if(num1 + num2 == num3) {
				System.out.println(map);
			}
			
			return;
		}
		
		char ch = uniqueStr.charAt(index);
		for (int i = 0; i < digitUsed.length; i++) {
			if(!digitUsed[i]) {
				digitUsed[i] = true;
				map.put(ch, i);
				printpuzzlesUtil(s1, s2, s3, index + 1, uniqueStr, map, digitUsed);
				map.put(ch, -1);
				digitUsed[i] = false;
			}
		}
	}

	private static int getNum(String s1, Map<Character, Integer> map) {
		String str = "";
		for(char ch : s1.toCharArray()) {
			str += map.get(ch);
		}
		
		return Integer.parseInt(str);
	}

	public static void main(String[] args) {
		
//		send + more = money
		
		String s1 = "send";
		String s2 = "more";
		String s3 = "money";
		
		printPuzzles(s1, s2, s3);
	}
}
