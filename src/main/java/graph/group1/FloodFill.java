package graph.group1;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color) {
            dfs(image, sr, sc, image[sr][sc], color);
        }

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }

        image[sr][sc] = color;

        dfs(image, sr - 1, sc, oldColor, color);
        dfs(image, sr, sc + 1, oldColor, color);
        dfs(image, sr + 1, sc, oldColor, color);
        dfs(image, sr, sc -1, oldColor, color);
    }
}
