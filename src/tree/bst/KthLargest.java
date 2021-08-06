package tree.bst;

public class KthLargest {

	int count;
	int res = -1;

	public int kthLargest(Node root, int k) {
		count = 0;
		reverseInorder(root, k);
		return res;
	}

	void reverseInorder(Node root, int k) {
		if (root == null)
			return;

		reverseInorder(root.right, k);

		count++;
		if (count == k)
			res = root.data;

		reverseInorder(root.left, k);
	}
}
