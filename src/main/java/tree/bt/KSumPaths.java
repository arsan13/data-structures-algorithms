package tree.bt;

import java.util.ArrayList;
import java.util.List;

//Given the root of a binary tree and an integer targetSum, 
//return the number of paths where the sum of the values along the path equals targetSum.
public class KSumPaths {
	List<Integer> path;
    int count;
    
    public int pathSum(Node root, int targetSum) {
        
        path = new ArrayList<>();
        count = 0;
        
        pathSumUtil(root, targetSum);
        return count;
    }
    
    private void pathSumUtil(Node root, int k) {
        
        if(root == null)
            return;
        
        path.add(root.data);
        
        pathSumUtil(root.left, k);
        pathSumUtil(root.right, k);
        
        int sum = 0;
        for(int i = path.size()-1; i >= 0; i--) {
            sum += path.get(i);
            
            if(sum == k) {
                // printList(path, i);
                count++;
            }
        }
        path.remove(path.size()-1);
    }
    
    private void printList(List<Integer> path, int j) {
        for(int i = j; i <path.size(); i++)
            System.out.print(path.get(i) + " ");
        System.out.println();
    }
}
