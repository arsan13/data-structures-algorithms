package tree.bst;

public class KthLargest {

	int count;
	int res = -1;

	public int kthLargest(TreeNode root, int k) {
		count = 0;
		reverseInorder(root, k);
		return res;
	}

	void reverseInorder(TreeNode root, int k) {
		if (root == null)
			return;

		reverseInorder(root.right, k);

		count++;
		if (count == k)
			res = root.val;

		reverseInorder(root.left, k);
	}
}
