package backtracking.level2;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

//	0 to n-1
//	private static int survivor(int n, int k) {
//		
//		if(n == 1)
//			return 0;
//		
//		int x = survivor(n-1, k);
//		int y = (x + k) % n;
//		
//		return y;
//	}

//	1 to n
	private static int survivor(int n, int k) {

		if (n == 1)
			return 1;

		int x = survivor(n - 1, k);
		int y = (x + k - 1) % n + 1;

		return y;
	}
	
	private static int survivorUsingList(int n, int k) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) // 1 to n
			list.add(i);
		k = k - 1;
		return survivorUsingListUtil(0, n, k, list);
	}
	
	private static int survivorUsingListUtil(int index, int n, int k, List<Integer> list) {
		
		if(list.size() == 1) {
			return list.get(0);
		}
		
		index = (index + k) % n;
		list.remove(index);
		
		return survivorUsingListUtil(index, list.size(), k, list);
	}

	public static void main(String[] args) {

		int n = 5;
		int k = 2;
		System.out.println(survivor(n, k));
		System.out.println(survivorUsingList(n, k));
	}
}
