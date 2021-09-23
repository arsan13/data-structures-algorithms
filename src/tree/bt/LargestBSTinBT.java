package tree.bt;

/**
 * Given a binary tree, find the size of largest binary search subtree in this binary tree. 
 * Here, size is equal to the number of nodes in the subtree forming BST.
 * 
 * Traverse tree in post order fashion. Left and right nodes return 4 piece(Quartet)
 * of information to root which isBST, size of max BST, min and max in those subtree. 
 * If both left and right subtree are BST and this node data is greater than max
 * of left and less than min of right then it returns to above level left size + right size + 1 
 * and new min will be min of left side and new max will be max of right side.
 */
public class LargestBSTinBT {
	
	private class Quartet {
		boolean isBST;
		int min;
		int max;
		int size;
		
		public Quartet(boolean isBST, int min, int max, int size) {
			this.isBST = isBST;
			this.min = min;
			this.max = max;
			this.size = size;
		}
	}
	
	public int largestBst(Node root) {
		Quartet q = largestBstUtil(root);
		return q.size;
	}

	private Quartet largestBstUtil(Node root) {
		//if root is null return min as Integer.MAX and max as Integer.MIN 
		if(root == null)
			return new Quartet(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		
		//Post-order traversal
		Quartet left = largestBstUtil(root.left);
		Quartet right = largestBstUtil(root.right);
		
		//if either of left or right subtree is not BST or the data of this 
        //node is not greater/equal than max of left and less than min of right
        //then subtree with this node as root will not be BST. 
        //Return false and max size of left and right subtree to parent.
		if(left.isBST == false || right.isBST == false || root.data <= left.max || root.data >= right.min) {
			int tempSize = Math.max(left.size, right.size);
			return new Quartet(false, Integer.MAX_VALUE, Integer.MIN_VALUE, tempSize);
		}
		
		//if we reach this point means subtree with this node as root is BST.
        //Set isBST as true. Then set size as size of left + size of right + 1.
        //Set min and max to be returned to parent.
		int tempSize = 1 + left.size + right.size;
		int tempMin = root.left != null ? left.min : root.data;
		int tempMax = root.right != null ? right.max : root.data;
		
		return new Quartet(true, tempMin, tempMax, tempSize);
	}
}
