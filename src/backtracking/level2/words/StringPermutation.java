package backtracking.level2.words;

public class StringPermutation {

	private static void addSpace(int index, String str, String ans) {

		if (index == str.length()) {
			System.out.print(ans + "  ");
			return;
		}

		if (index == 0)
			addSpace(index + 1, str, ans + str.charAt(index));
		else if (index > 0) {
			addSpace(index + 1, str, ans + "-" + str.charAt(index));
			addSpace(index + 1, str, ans + str.charAt(index));
		}
	}

	private static void caseChange(int index, String str, String ans) {

		if (index == str.length()) {
			System.out.print(ans + "  ");
			return;
		}
		
		char ch = Character.toUpperCase(str.charAt(index));
		caseChange(index + 1, str, ans + ch);
		caseChange(index + 1, str, ans + str.charAt(index));
	}
	
	private static void caseChange2(int index, String str, String ans) {

		if (index == str.length()) {
			System.out.print(ans + "  ");
			return;
		}
		
		char ch = str.charAt(index);
		
		if(Character.isDigit(ch)) {
			caseChange2(index + 1, str, ans + ch);			
		}
		else {			
			caseChange2(index + 1, str, ans + ch);
			if(Character.isLowerCase(ch)) {
				ch = Character.toUpperCase(ch);
				caseChange2(index + 1, str, ans + ch);
			}
			else {
				ch = Character.toLowerCase(ch);
				caseChange2(index + 1, str, ans + ch);
			}
		}
	}
	public static void main(String[] args) {
		

		addSpace(0, "ABCD", "");
		System.out.println();
		caseChange(0, "ab", "");
		System.out.println();
		caseChange2(0, "a1Bc", "");
	}
}
