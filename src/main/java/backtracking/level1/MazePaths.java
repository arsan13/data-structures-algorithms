package backtracking.level1;

import java.util.ArrayList;
import java.util.List;

public class MazePaths {

	private static int countPaths(int i, int j, int m, int n) {

		if (i > m || j > n)
			return 0;

		if (i == m && j == n)
			return 1;

		int r = countPaths(i + 1, j, m, n);
		int c = countPaths(i, j + 1, m, n);

		return r + c;
	}

	private static int countPaths(int m, int n) {

		if (m == 1 || n == 1)
			return 1;

		int r = countPaths(m - 1, n);
		int c = countPaths(m, n - 1);

		return r + c;
	}

	private static List<String> getPaths(int i, int j, int m, int n) {

		List<String> paths = new ArrayList<>();
		getPathsUtil(i, j, m, n, "", paths);
		return paths;
	}

	private static void getPathsUtil(int i, int j, int m, int n, String path, List<String> paths) {

		if (i > m || j > n) {
			return;
		}

		if (i == m && j == n) {
			paths.add(path);
			return;
		}

		getPathsUtil(i + 1, j, m, n, path + "H", paths);
//		getPathsUtil(i + 2, j, m, n, path + "2H", paths);
//		getPathsUtil(i + 3, j, m, n, path + "3H", paths);

		getPathsUtil(i, j + 1, m, n, path + "V", paths);
//		getPathsUtil(i, j + 2, m, n, path + "2V", paths);
//		getPathsUtil(i, j + 3, m, n, path + "3V", paths);

//		getPathsUtil(i + 1, j+1, m, n, path + "1D", paths); // diagonal
//		getPathsUtil(i + 2, j+2, m, n, path + "2D", paths); // diagonal
//		getPathsUtil(i + 3, j+3, m, n, path + "3D", paths); // diagonal
	}

	public static void main(String[] args) {

		System.out.println(getPaths(1, 1, 3, 3));
		System.out.println(countPaths(1, 1, 3, 3));
		System.out.println(countPaths(3, 3));
	}
}
