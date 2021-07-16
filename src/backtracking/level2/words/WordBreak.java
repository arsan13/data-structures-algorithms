package backtracking.level2.words;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	private static void sentences(String str, Set<String> set, String ans) {

		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		for(int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i+ 1);
			if(set.contains(left)) {
				String right = str.substring(i+1);
				sentences(right, set, ans + left + " ");
			}
		}
	}
	
	public static void main(String[] args) {

		String str = "microsoftinhiring";
		
		Set<String> set = new HashSet<>();
		set.add("microsoft");
		set.add("micro");
		set.add("soft");
		set.add("in");
		set.add("hiring");
		
		sentences(str, set, "");
	}
}
