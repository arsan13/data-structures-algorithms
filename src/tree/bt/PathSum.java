package tree.bt;

//Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path 
//such that adding up all the dataues along the path equals targetSum.
public class PathSum {

	public boolean hasPathSum(Node root, int targetSum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null) {
			if (root.data == targetSum)
				return true;
			else
				return false;
		}

		return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
	}
}
