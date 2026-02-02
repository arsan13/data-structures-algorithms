package tree.bt;

/*Two trees are called isomorphic if one can be obtained from another by a series of flips, i.e. by swapping left and 
right children of several nodes. Any number of nodes at any level can have their children swapped. 
Two empty trees are isomorphic.*/
public class IsomorphicTree {
	/*
	 * Conditions for trees n1 and n2 to be isomorphic
	 * 1) Data of n1 and n2 is same. 
	 * 2) One of the following two is true for children of n1 and n2 
	 * a) Left child of n1 is isomorphic to left child of n2 and right child of n1 is isomorphic to right child of n2. 
	 * b) Left child of n1 is isomorphic to right child of n2 and right child of n1 is isomorphic to left child of n2.
	 */
	public boolean isIsomorphic(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.data != root2.data)
			return false;

		boolean same = isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);
		boolean mirror = isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left);

		if (same || mirror)
			return true;
		return false;
	}
}
