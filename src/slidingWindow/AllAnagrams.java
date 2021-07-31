package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class AllAnagrams {

	private static int anagrams(String s, String p) {
		if (p.length() > s.length() || s.length() <= 0 || p.length() <= 0)
			return 0;

		int count = 0;
		Map<Character, Integer> pmap = new HashMap<>();
		Map<Character, Integer> smap = new HashMap<>();

		for (char ch : p.toCharArray()) {
			pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
		}

		char ch;
		int i = 0;
		int j = 0;
		while (j < s.length()) {
			ch = s.charAt(j);
			smap.put(ch, smap.getOrDefault(ch, 0) + 1);

			// p.length() is the window size
			if (j - i + 1 == p.length()) {
				if (compare(smap, pmap)) {
					System.out.println("index: " + i);
					count++;
				}

				// Release
				ch = s.charAt(i);
				if (smap.get(ch) > 1) {
					smap.put(ch, smap.get(ch) - 1);
				} else {
					smap.remove(ch);
				}
				i++;
			}
			
			j++;
		}

		return count;
	}
	
//	private static int anagrams(String s, String p) {
//		if(p.length() > s.length() || s.length() <= 0 || p.length() <= 0)
//            return 0;
//		
//		int count = 0;
//		Map<Character, Integer> pmap = new HashMap<>();
//		Map<Character, Integer> smap = new HashMap<>();
//		
//		for(char ch : p.toCharArray()) {
//			pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
//		}
//		
//		// p.length() is the window size
//		for(int i = 0; i < p.length(); i++) {
//			char ch = s.charAt(i);
//			smap.put(ch, smap.getOrDefault(ch, 0) + 1);
//		}
//		
//		char ch;
//		int i = 0;
//		int j = p.length();
//		while(j < s.length()) {
//			//Work
//			if(compare(smap, pmap)) {
//				System.out.println(i);
//				count++;
//			}
//			
//			//SLIDE WINDOW
//			
//			//Acquire
//			ch = s.charAt(j);
//			smap.put(ch, smap.getOrDefault(ch, 0) + 1);
//			
//			//Release
//			ch = s.charAt(i);
//			if(smap.get(ch) > 1) {
//				smap.put(ch, smap.get(ch) - 1);
//			} else {
//				smap.remove(ch);
//			}
//			
//			j++;
//			i++;
//		}
//		
//		if(compare(smap, pmap)) {
//			System.out.println(i);
//			count++;
//		}
//		
//		return count;
//	}

	private static boolean compare(Map<Character, Integer> smap, Map<Character, Integer> pmap) {
		for (char ch : smap.keySet()) {
			if (smap.get(ch) != pmap.getOrDefault(ch, 0)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

//		String s = "cbaebabacd";
//		String p = "abc";
		String s = "aaaaaa";
		String p = "aaa";
		System.out.println("Count = " + anagrams(s, p));
	}

}
