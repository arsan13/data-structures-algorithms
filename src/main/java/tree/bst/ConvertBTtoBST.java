package tree.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertBTtoBST {
	List<Integer> list;
	int index;

	public TreeNode binaryTreeToBST(TreeNode root) {
		list = new ArrayList<>();
		index = 0;

		inorder(root);
		Collections.sort(list);
		listToBST(root);

		return root;
	}

	private void inorder(TreeNode root) {
		if (root == null)
			return;

		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}

	private void listToBST(TreeNode root) {
		if (root == null)
			return;

		listToBST(root.left);
		root.val = list.get(index++);
		listToBST(root.right);
	}
}
