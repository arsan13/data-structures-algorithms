package tree.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertBTtoBST {
	List<Integer> list;
	int index;

	public Node binaryTreeToBST(Node root) {
		list = new ArrayList<>();
		index = 0;

		inorder(root);
		Collections.sort(list);
		listToBST(root);

		return root;
	}

	private void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		list.add(root.data);
		inorder(root.right);
	}

	private void listToBST(Node root) {
		if (root == null)
			return;

		listToBST(root.left);
		root.data = list.get(index++);
		listToBST(root.right);
	}
}
