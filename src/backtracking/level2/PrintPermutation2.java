package backtracking.level2;

import java.util.HashMap;
import java.util.Map;

// String with repeated character....n!/repeated_ch!

public class PrintPermutation2{

	public static void permutations(String str) {

		Map<Character, Integer> lastOccurence = new HashMap<>();
		for (char ch : str.toCharArray())
			lastOccurence.put(ch, -1);

		Character[] spots = new Character[str.length()];
		permutationsUtil(str, 0, spots, lastOccurence);
	}

	private static void permutationsUtil(String str, int currentChar, Character[] spots, Map<Character, Integer> lastOccurence) {

		if(currentChar == str.length()) {
			for(char ch : spots) 
				System.out.print(ch);
			System.out.print(" ");
			return;
		}
		
		char ch = str.charAt(currentChar);
		int lo = lastOccurence.get(ch);
		
		for(int i = lo + 1; i < spots.length; i++) {
			if(spots[i] == null) {
				spots[i] = ch;
				lastOccurence.put(ch, i);
				permutationsUtil(str, currentChar + 1, spots, lastOccurence);
				lastOccurence.put(ch, lo);
				spots[i] = null;
			}
		}
	}

	public static void main(String[] args) {

		permutations("aabb");
	}
}
