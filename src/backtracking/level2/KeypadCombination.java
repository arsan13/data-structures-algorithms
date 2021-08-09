package backtracking.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeypadCombination {

//	static String[] codes = {"\0", "\0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
//	private static List<String> getCombination(String str) {
//		
//		if(str.length() == 0) {
//			List<String> bres = new ArrayList<>();
//			bres.add("");
//			return bres;
//		}
//			
//		char ch = str.charAt(0);
//		String ros = str.substring(1);
//		
//		List<String> rres = getCombination(ros);
//		List<String> mres = new ArrayList<>();
//		
//		String strOfCh = codes[ch - '0']; // - 0 is used to convert charater to int
//		for(char mch : strOfCh.toCharArray()) {
//			for(String rstr : rres)
//				mres.add(mch + rstr);
//		}
//		
//		return mres;
//	}

//	static ArrayList <String> possibleWords(int a[], int N)
//    {
//        String[] codes = {"\0", "\0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        
//        ArrayList<String> list =  getCombination(0, a, codes);  
//        Collections.sort(list);
//        
//        return list;
//    }
//	
//	private static ArrayList<String> getCombination(int index, int[] a, String[] codes) {
//		
//    	if(index == a.length) {
//			ArrayList<String> bres = new ArrayList<>();
//			bres.add("");
//			return bres;
//		}
//			
//		int first = a[index++];
//		
//		ArrayList<String> rres = getCombination(index, a, codes);
//		ArrayList<String> mres = new ArrayList<>();
//		
//		String strOfFirst = codes[first]; 
//		for(char ch : strOfFirst.toCharArray()) {
//			for(String rstr : rres)
//				mres.add(ch + rstr);
//		}
//		
//		return mres;
//	}

	private static ArrayList<String> possibleWords(int[] arr, int n) {

		String[] codes = {"\0", "\0", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ArrayList<String> list = new ArrayList<>();
		getCombination(arr, 0, n, codes, "", list);
		return list;
	}

	private static void getCombination(int[] arr, int index, int n, String[] codes, String str, ArrayList<String> list) {
		if(index == n) {
			list.add(str);
			return;
		}
			
		int first = arr[index++];
		String strOfFirst = codes[first];
		
		for(char ch : strOfFirst.toCharArray()) {
			getCombination(arr, index, n, codes, str+ch, list);
		}
		
	}

	public static void main(String[] args) {

//		String str = "678";
		int[] arr = { 2, 3, 4 };
		System.out.println(possibleWords(arr, arr.length));
	}
}
