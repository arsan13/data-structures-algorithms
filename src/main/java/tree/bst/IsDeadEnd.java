package tree.bst;

//Return true if the BST contains a dead end else returns false. 
//Dead End means, we are not able to insert any element after that node.
public class IsDeadEnd {

	public boolean isDeadEnd(Node root) {
		int min = 1; // Given, BST contains positive integer values greater then 0
		int max = Integer.MAX_VALUE;

		return isDeadEnd(root, min, max);
	}

	private boolean isDeadEnd(Node root, int min, int max) {
		if (root == null)
			return false;

//		 if(max - min <= 2)
//			 return true;
		// return isDeadEnd(root.left, min, root.data) || isDeadEnd(root.right, root.data, max);

		if (min == max)
			return true;
		
		boolean leftCheck = isDeadEnd(root.left, min, root.data - 1);
		boolean rightCheck = isDeadEnd(root.right, root.data + 1, max);
		return leftCheck || rightCheck;
	}
}
