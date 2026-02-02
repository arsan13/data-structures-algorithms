package tree.bt.group2;

/**
 * Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a BST.
 * 
 * Pre-requisite: Largest BST in BT.  
 */
public class MaxSumBSTinBT {
	
	private class Quartet {
		boolean isBST;
		int min;
		int max;
		int sum;
		
		public Quartet(boolean isBST, int min, int max, int sum) {
			this.isBST = isBST;
			this.min = min;
			this.max = max;
			this.sum = sum;
		}
	}
	
	int res = 0;
	public int largestBst(Node root) {
		Quartet q = largestBstUtil(root);
		return res;
	}

	private Quartet largestBstUtil(Node root) {
		//if root is null return min as Integer.MAX and max as Integer.MIN 
		if(root == null)
			return new Quartet(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		
		//Post-order traversal
		Quartet left = largestBstUtil(root.left);
		Quartet right = largestBstUtil(root.right);
		
		if(left.isBST == false || right.isBST == false || root.data <= left.max || root.data >= right.min) {
			int tempSum = Math.max(left.sum, right.sum);
			return new Quartet(false, Integer.MAX_VALUE, Integer.MIN_VALUE, tempSum);
		}
		
		//At this point subtree with the current node will be BST.
		int tempSum = root.data + left.sum + right.sum;
		int tempMin = root.left != null ? left.min : root.data;
		int tempMax = root.right != null ? right.max : root.data;
		
		// Max sum will be present anywhere in between the tree
		res = Math.max(res, tempSum);
		
		return new Quartet(true, tempMin, tempMax, tempSum);
	}
}
