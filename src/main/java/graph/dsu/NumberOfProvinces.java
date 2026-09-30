package graph.dsu;

public class NumberOfProvinces {

    public int count(int[][] matrix) {
        int n = matrix.length;

        DisjointSet ds =  new DisjointSet(n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if( i != j && matrix[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

        return ds.countComponents();
    }
}
