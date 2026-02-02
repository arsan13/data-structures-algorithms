package tree.bt.height;

// Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.
public class MaxPathSum {

	int res;

	int findMaxSum(Node node) {
		res = Integer.MIN_VALUE;
		solve(node);

		return res;
	}

	// Similar to the height of the tree function
	private int solve(Node root) {
		if (root == null)
			return 0;

		//Max(0, solve()) and not just solve() is used to ignore negative value sums.
		int left = Math.max(0, solve(root.left));  	
        int right = Math.max(0, solve(root.right));
        
        res = Math.max(res, root.data + left + right);
        
        return root.data + Math.max(left, right);
	}
}
