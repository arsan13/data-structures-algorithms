package binarySearch;

//Search in a row wise and column wise sorted matrix
public class SearchInAMatrix {
	
	// O(n + m) time complexity
	private static String search(int[][] mat, int key) {
		int i = 0; //row
		int j = mat[0].length - 1; //column
		
		while (i < mat.length && j >= 0) {
			if(mat[i][j] > key) {
				j--;
			} else if(mat[i][j] == key) {
				return String.format("(%d, %d)", i, j);
			} else {
				i++;
			}
		}
		
		return "-1";
	}
	
	public static void main(String args[]) {
		
		int x = 29;
		int mat[][] = { {10, 20, 30, 40},
		                {15, 25, 35, 45},
		                {27, 29, 37, 48},
		                {32, 33, 39, 50}};
		
		System.out.println(search(mat, x));
	}
}
