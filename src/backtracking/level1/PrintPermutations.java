package backtracking.level1;

// String with distinct characters...n!

public class PrintPermutations {

	private static void permutations(String ques, String ans) {
		
		if(ques.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		
		// Using StringBuilder
//		for(int i = 0; i < ques.length(); i++) {
//			char ch = ques.charAt(i);
//			StringBuilder temp = new StringBuilder(ques);
//			temp.deleteCharAt(i);
//			permutations(temp.toString(), ans+ch);
//		}
		
		for(int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String temp = ques.substring(0, i) + ques.substring(i+1);
			permutations(temp, ans+ch);
		}
	}
	
	public static void main(String[] args) {
		
		permutations("abc", "");
	}
}
