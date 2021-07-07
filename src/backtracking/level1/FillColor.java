package backtracking.level1;

// Based on DFS 

public class FillColor {
	
	public static void floodFill(int[][] image, int sr, int sc, int newColor)
    {
        if(image[sr][sc] != newColor)
            floodFillUtil(sr, sc, image[sr][sc], newColor, image);
    }
    
    private static void floodFillUtil(int i, int j, int oldColor, int newColor, int[][] image) {
        
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor)
            return;
        
        image[i][j] = newColor;
        
        floodFillUtil(i-1, j, oldColor, newColor, image);
        floodFillUtil(i+1, j, oldColor, newColor, image);
        floodFillUtil(i, j-1, oldColor, newColor, image);
        floodFillUtil(i, j+1, oldColor, newColor, image);
    }
	
	public static void main(String[] args) {

		int sr = 1, sc = 1, newColor = 2;
		int[][] image = { { 1, 1, 1 }, 
						  { 1, 1, 0 }, 
						  { 1, 0, 1 } };
		
		floodFill(image, sr, sc, newColor);
		
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image.length; j++) 
				System.out.print(image[i][j] + " ");
			System.out.println();
		}
	}

}
