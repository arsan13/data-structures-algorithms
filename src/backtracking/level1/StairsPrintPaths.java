package backtracking.level1;

import java.util.ArrayList;
import java.util.List;

public class StairsPrintPaths {

	// Upto 3 paths are allowed
	private static List<String> getPaths(int n) {

//		if(n == 0) {
//			List<String> bres = new ArrayList<>();
//			bres.add("");
//			return bres;
//		}
//		else if(n < 0) {
//			return new ArrayList<>();
//		}
//		
//		List<String> path1 = getPaths(n - 1);
//		List<String> path2 = getPaths(n - 2);
//		List<String> path3 = getPaths(n - 3);
//		List<String> paths = new ArrayList<>();
//
//		for (String path : path1)
//			paths.add(1 + path);
//		for (String path : path2)
//			paths.add(2 + path);
//		for (String path : path3)
//			paths.add(3 + path);
//
//		return paths;

		List<String> paths = new ArrayList<>();
		getPathsUtil(n, "", paths);
		return paths;
	}

	private static void getPathsUtil(int n, String path, List<String> paths) {

		if(n < 0)
			return;
		
		if (n == 0) {
			paths.add(path);
			return;
		} 

		for(int i = 1; i <= 3; i++)
			getPathsUtil(n - i, path+i, paths);
	}

	public static void main(String[] args) {

		System.out.println(getPaths(4));
	}
}
